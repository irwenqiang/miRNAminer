package mirnaminer;

import java.io.*;

//import java.util.*;
/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author Quan Zou
 * @version 1.0
 */
public class Extend {
	int fastaline = 70;// ���fasta��ʽ�����в����У���������ó������
	String databasefile = "assembledset.txt";
	String blastnresult = "blastn_info.txt";

	/**
	 * ��fasta��ʽ���ļ��У�һ���ж�����ĸ
	 * 
	 * @return int
	 */
	private int getfastaline() {
		int fastaline = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(databasefile));
			int num = 0;

			while (br.ready()) {
				String line = br.readLine().trim();

				if (num > 50) // ��ǰ50�о͹���
					break;
				if (line.length() == 0)
					continue;
				if (line.charAt(0) == '>')
					continue;
				if (line.length() > fastaline)
					fastaline = line.length();
				num++;
			}
		} catch (Exception ex) {
			System.out
					.println("Exception thrown in getfastaline() @ extend.java");
			System.out.println(ex.getLocalizedMessage());
			System.exit(0);
		}
		if (fastaline > 100)
			fastaline = Integer.MAX_VALUE / 2;

		return fastaline;
	}

	public Extend() {
	}

	public String nibu(String dna) {
		dna = dna.toUpperCase().replace('U', 'T');
		StringBuffer sb = new StringBuffer();
		for (int i = dna.length() - 1; i >= 0; i--) {
			if (dna.charAt(i) == 'A')
				sb.append('T');
			else if (dna.charAt(i) == 'C')
				sb.append('G');
			else if (dna.charAt(i) == 'G')
				sb.append('C');
			else if (dna.charAt(i) == 'T')
				sb.append('A');
			else
				sb.append('N');
		}
		return sb.toString();
	}

	public String reverse(String dna) {
		dna = dna.toUpperCase().replace('U', 'T');
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < dna.length(); i++) {
			if (dna.charAt(i) == 'A')
				sb.append('T');
			else if (dna.charAt(i) == 'C')
				sb.append('G');
			else if (dna.charAt(i) == 'G')
				sb.append('C');
			else if (dna.charAt(i) == 'T')
				sb.append('A');
			else
				sb.append('N');
		}
		return sb.toString();

	}

	public int lengthofmature(String name) {
		int len = 20;
		try {
			BufferedReader br = new BufferedReader(new FileReader("mature.fa"));
			while (br.ready()) {
				String tmp = br.readLine();
				if (tmp.length() == 0)
					continue;
				if (tmp.indexOf(name) != -1) {
					len = br.readLine().trim().length();
					break;
				}
			}
			br.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return len;
	}

	public void run() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(blastnresult));

			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"sang1zong.txt"));
			int ooo = 0;
			while (br.ready()) {
				System.out.println(ooo);
				ooo++;
				String maturename = br.readLine();
				String genomename = br.readLine();

				// int genomelength =
				// Integer.parseInt(genomename.substring(genomename.indexOf("/length=")+8,genomename.indexOf(" /lengthwogaps=")));

				String query = br.readLine();
				String sbjct = br.readLine();
				br.readLine();

				int seedend = Integer.parseInt(query.substring(query
						.lastIndexOf(' ') + 1));
				query = query.substring(query.indexOf(' ') + 1);
				int seedbegin = Integer.parseInt(query.substring(0,
						query.indexOf(' ')));

				int matureend = Integer.parseInt(sbjct.substring(sbjct
						.lastIndexOf(' ') + 1));
				sbjct = sbjct.substring(sbjct.indexOf(' ') + 1);
				int maturebegin = Integer.parseInt(sbjct.substring(0,
						sbjct.indexOf(' ')));
				int matureend_forever = matureend;
				int maturebegin_forever = maturebegin;

				bw.write(">" + genomename);
				bw.newLine();
				bw.write(maturename);
				bw.newLine();

				if (maturebegin < matureend) {
					if (seedbegin > 1)
						maturebegin = Math.max(0, maturebegin - seedbegin + 1);
					if (seedend < lengthofmature(maturename))
						matureend += lengthofmature(maturename) - seedend;

					bw.write("sense");
					bw.newLine();
					bw.write("mature miRNA position:"
							+ String.valueOf(maturebegin) + "-->"
							+ String.valueOf(matureend));
					bw.newLine();

					bw.flush();

					BufferedReader br_genome = new BufferedReader(
							new FileReader(databasefile));
					String chromosome = "";

					while (br_genome.ready()) {
						String tmp = br_genome.readLine();
//						System.out.println("+++++++++++++" + tmp + "\n" + genomename);

						if (tmp.indexOf(genomename) != -1) {
							System.out.println("Find--------------");
							int i = maturebegin - 100;
							while (i > fastaline) {
								i -= fastaline;
								br_genome.readLine();
								maturebegin -= fastaline;
								matureend -= fastaline;
							}

							StringBuffer sb = new StringBuffer();
							tmp = br_genome.readLine();
//							System.err.println(">>" + tmp);
							int j = 5;
							while (tmp.length() != 0 && tmp.charAt(0) != '>'
									&& j > 0 && tmp.charAt(0) != '/') {
								sb.append(tmp);
								j--;
								if (!br_genome.ready())
									break;
								tmp = br_genome.readLine();
							}
							chromosome = sb.toString();
							break;
						}

					}

					if (chromosome.length() == 0) {
						System.out
								.println("Errors!Do not find the sequence in the database");
						continue;
					}

					br_genome.close();
					if (matureend + 100 >= chromosome.length()) {
						matureend_forever -= matureend + 100
								- chromosome.length();
					}
					bw.write("pre-miRNA position:"
							+ String.valueOf(Math.max(1,
									maturebegin_forever - 99)) + "-->"
							+ String.valueOf(matureend_forever + 100));
					bw.newLine();

					String mature = chromosome.substring(maturebegin,
							Math.min(matureend, chromosome.length()));

					String precursor = chromosome.substring(
							Math.max(0, maturebegin - 100),
							Math.min(matureend + 100, chromosome.length()));
					bw.write(mature);
					bw.newLine();
					bw.write(precursor);
					bw.newLine();

					bw.newLine();
					bw.flush();

				} else {
					if (seedbegin > 1)
						maturebegin = maturebegin + seedbegin - 1;
					if (seedend < lengthofmature(maturename))
						matureend -= lengthofmature(maturename) - seedend;
					if (matureend < 1)
						matureend = 1;

					bw.write("antisense");
					bw.newLine();
					bw.write("mature miRNA position:"
							+ String.valueOf(maturebegin) + "-->"
							+ String.valueOf(matureend));
					bw.newLine();

					bw.flush();

					BufferedReader br_genome = new BufferedReader(
							new FileReader(databasefile));
					String chromosome = "";
					while (br_genome.ready()) {
						String tmp = br_genome.readLine();
						if (tmp.indexOf(genomename) != -1) {

							int i = matureend - 100;
							while (i > fastaline) {
								i -= fastaline;
								br_genome.readLine();
								maturebegin -= fastaline;
								matureend -= fastaline;
							}

							StringBuffer sb = new StringBuffer();
							tmp = br_genome.readLine();
							System.out.println("---------------" + tmp);
							int j = 5;

							while (tmp.length() != 0 && tmp.charAt(0) != '>'
									&& j > 0) {
								sb.append(tmp);
								j--;
								if (!br_genome.ready())
									break;
								tmp = br_genome.readLine();
							}
							chromosome = sb.toString();
							break;
						}

					}
					br_genome.close();

					if (chromosome.length() == 0) {
						System.out
								.println("Errors!Do not find the sequence in the database");
						continue;
					}

					if (maturebegin + 100 >= chromosome.length()) {
						maturebegin_forever -= maturebegin + 100
								- chromosome.length();
					}

					bw.write("pre-miRNA position:"
							+ String.valueOf(maturebegin_forever + 100)
							+ "-->"
							+ String.valueOf(Math
									.max(matureend_forever - 99, 1)));
					bw.newLine();

					String mature = chromosome.substring(matureend - 1,
							Math.min(maturebegin, chromosome.length()));
					String precursor = chromosome.substring(
							Math.max(0, matureend - 100),
							Math.min(maturebegin + 100, chromosome.length()));
					bw.write(">next two lines are sequences in genome,but reversed");
					bw.newLine();
					bw.write(reverse(mature));
					bw.newLine();
					bw.write(reverse(precursor));
					bw.newLine();

					bw.write(">next two lines are sequences in genome");
					bw.newLine();
					bw.write(mature);
					bw.newLine();
					bw.write(precursor);
					bw.newLine();
					bw.write(">next two lines are sequences in antisense chain");
					bw.newLine();
					bw.write(nibu(mature));
					bw.newLine();
					bw.write(nibu(precursor));
					bw.newLine();

					bw.newLine();
					bw.flush();

				}

			}

			br.close();
			bw.close();
			System.out.println("ok");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						"errorlog.txt"));
				bw.write(ex.getMessage());
				bw.close();
			} catch (Exception eex) {
				System.out.println();
			}
		}
	}
}
