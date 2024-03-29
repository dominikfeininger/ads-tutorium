package uebung04;

import static gdi.MakeItSimple.*;

public class NaturalMergeSort {
	public static String input;
	public static void main(String[] args) {
		println("Please enter a file name (name.txt):");
		// read file name
		input = readLine();
		Object file = openOutputFile("c:\\" + input);
		// test if file present
		if (isFilePresent("c:\\" + input)) {
			print(file,
					"1001 4442 1622 3972 3558 2555 4607 2059 3845 941 3718 3491 4155 402 2205 3742 4185 3679 4126 2723 1875 465 4782 1898 4781 1822 1175 4829 2687 1528 3067 3274 2762 4551 3304 2314 3731 1197 271 2113 793 4692 4169 3257 2117 2113 1143 3462 4197 986 2875 3471 3563 1326 719 2026 2371 4225 3460 3743 3391 4819 2445 916 4222 792 4002 4095 2522 116 51 399 286 522 4819 4610 3219 2863 2630 1481 1344 4112 2668 1927 404 4649 2568 3153 651 2143 535 4910 1722 691 1519 3556 3295 1920 202 2867 4530 2913 4314 4443 3377 4126 1041 2850 4436 1321 4501 4797 252 543 3006 466 4847 3269 3509 3374 1425 4891 2246 1724 1284 2569 3631 2481 3009 3709 4501 2675 1374 521 1764 2968 4185 282 2152 1293 139 3714 3940 967 332 210 614 2371 2915 2977 4291 2025 3299 332 733 548 1209 2682 2905 2457 3014 1166 2067 4794 3913 4451 294 3214 4613 808 1374 1083 1984 3187 391 2715 3343 3942 4777 1357 2129 2950 1103 4378 2623 1669 3047 1742 2641 1733 2194 1700 1562 3567 2828 4693 771 4934 3656 1562 3381 2537 1760 1068 2987 1383 4213 907 1205 1949 1945 1825 4719 2374 4355 4816 3505 1281 1737 2533 670 2030 4561 4503 2894 3082 4940 1011 3360 2541 1844 1974 4136 1348 4766 1538 1061 79 2673 4273 3579 4976 4438 2733 1981 4428 3207 1720 1214 3839 3611 1369 2347 1197 242 4967 2952 1500 4299 2119 4488 3857 365 3175 1352 4709 968 2596 4803 3165 1284 3262 762 3616 1866 2288 3520 1019 2537 848 1944 2171 3003 2599 4814 2757 3694 4904 4658 279 778 35 1531 1465 2872 1696 1840 605 4195 641 2616 4796 2904 2915 1269 2920 4289 1160 3473 739 3364 2360 4445 2400 72 3736 938 415 4670 565 1929 1315 157 3881 3608 4527 2251 2555 993 4645 4661 3712 2913 3978 4871 2606 166 4835 46 763 8 4426 4523 3970 3347 4192 219 1933 3225 1506 3108 2771 224 3763 4219 262 594 4764 4332 2666 2684 2779 2128 1889 2230 1610 4257 545 550 3215 4980 903 4107 1241 2801 3932 4026 1384 54 2219 3689 673 4670 4262 388 3855 1200 3621 1156 2700 461 2648 3915 2549 3840 4203 4501 3522 395 3631 1127 3197 2766 4692 920 4730 3216 1763 4147 4683 2887 4672 1580 414 2786 187 4798 4247 4840 25 332 3549 4558 685 2766 1894 1283 1764 3580 127 3650 114 1594 3568 4439 3681 3051 2432 44 4811 566 3544 1262 2086 2506 677 518 3794 1045 2553 1398 4416 1467 2924 1758 3515 1776 4951 4017 1310 4982 2163 4429 1857 1408 21 133 600 2177 69 629 2647 2582 4786 1227 4296 737 2698 4349 2959 4530 2030 1465 2812 1590 1865 1960 1074 3957 1954 1659 3369 534 4555 4720 574 2888 227 3820 4265 3769 3938 3826 1968 1632 4199 598 354 4094 3748 4730 1579 786 2636 4743 4076 1924 501 289 1757 3036 4935 3603 2344 3756 3674 2489 2494 3121 2486 4588 4369 4402 2103 3600 1101 1589 4892 4366 7 1257 1122 4330 624 203 2720 3841 1382 4451 2548 188 4710 3626 3365 4611 3276 453 1188 124 4290 1311 3923 1596 1930 4023 4925 2525 2050 1343 2103 222 730 483 3998 666 4040 276 1079 643 2740 2930 823 2234 2402 4111 4757 516 764 458 2056 835 1323 1877 4553 3714 2336 3178 2501 2038 4091 4421 3991 113 2530 2671 1466 2279 86 4730 4228 2099 111 1084 2745 2951 3719 2914 2918 2761 1178 2214 1421 3585 2927 1122 4354 869 127 1730 4497 304 2882 1321 1169 305 2124 1610 3363 2342 4474 3322 216 4765 2590 1761 1505 3932 3076 1728 2771 834 2028 2826 1825 295 2621 4920 4267 859 2584 3634 1477 3709 782 1601 2235 2559 3793 4349 3874 3106 448 4281 1138 1747 1224 4865 4947 2055 3876 524 3089 2713 2674 865 1270 3884 1985 46 3673 4052 4284 4040 4461 615 2765 1299 4218 4158 1465 2201 4472 3203 3738 2416 1765 2724 1796 2709 24 4754 1474 779 3582 2091 683 4313 1520 4327 981 1961 3756 3122 1980 104 4799 3754 320 2140 4357 3630 4424 2649 1912 1115 4109 4100 3055 4063 4592 754 53 110 125 1934 2195 4375 1030 2012 2674 4791 1516 1904 1147 1110 3935 1061 1844 4451 3758 4817 3764 390 2385 4936 2506 2703 2533 1743 4076 4993 1351 2290 4075 4720 2845 2256 2859 4809 2145 3310 1112 378 1352 2389 931 3321 1858 2417 1378 3199 534 1421 1637 4669 1741 4676 3327 2178 1847 4039 4567 2433 4988 3068 3575 3739 4146 1825 55 2738 4377 109 2862 69 827 926 1466 1787 3065 3584 4538 2497 2334 1185 944 4401 2105 2510 1717 2552 1145 1793 570 2636 1899 3028 4802 587 2210 943 3419 4869 4966 2450 346 4319 3402 3224 3557 2812 3372 803 117 2886 4015 1478 1260 3591 3175 1774 1224 1413 2142 719 1052 4114 3578 1023 2336 3056 1996 1601 1440 4321 2300 4972 1158 1629 4787 394 341 544 126 3934 3226 502 2407 248 4946 4174 709 2918 163 3117 1139 4820 1819 3226 3446 1974 4696 4069 145 48 4105 1734 3622 2666 1316 13 2065 3774 4167 923 4876 2351 4954 4435 4700 4824 55 2045 2908 1940 2705 3245 4138 2485 1187 4445 2296 1340 513 812 3033 4702 4200 641 921 2181 2075 2418 225 1364 4168 1662 2360 45 331 2790 1241 285 4045 4651 2014 2104 1825 3311 4512 2002 2620 2938 4313 418 572 796 2886 1772 280 2179 958 3084 3163 529 4449 3853 3971 1071 4812 2622 1537 1717 312 1075 3264 2747 2072 1193 2162 1195 2215 3676 3681 3018 163 1671 4984 1284 1199 809 591");
		}
		closeOutputFile(file);
		naturalMergeSort();
	}

	// method to switch 2 elements
	static void swap(int[] array, int idx1, int idx2) {
		int tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;
	}

	// method to print an array
	public static void printArray(int[] a) {
		// variable for print loop
		int i2 = 0;
		while (i2 < a.length) {
			// print array
			print(a[i2] + ", ");
			i2++;
		}
	}

	// method to load from file
	public static int[] loadFromFile() {
		int i = 0, c;
		int[] f;
		Object file = openInputFile("c:\\"+input);
		if (isFilePresent("c:\\"+input)) {
			// count elements in file
			while (!isEndOfInputFile(file)) {
				c = readInt(file);
				i++;
			}
			// new array for integer values from file
			f = new int[i];
			closeInputFile(file);
			file = openInputFile("c:\\"+input);
			i = 0;

			// write elements in array
			while (!isEndOfInputFile(file)) {
				c = readInt(file);
				f[i] = c;
				i++;
			}

		} else {
			f = new int[1];
			println("## file doesn't exist!");
		}
		closeInputFile(file);
		return f;
	}

	public static void naturalMergeSort() {
		println("natural merge sort");
		println("initialarray: ");
		printtape("c:\\"+input);
		println();
		int[] unsorted = loadFromFile();

		while (!isSorted(unsorted)) {
			split(unsorted);
			printtape("c:\\Band1.txt");
			printtape("c:\\Band2.txt");
			println();

			merge();
			printtape("c:\\"+input);

			unsorted = loadFromFile();
		}
	}

	// method which prints content of a file
	private static void printtape(String path) {
		Object file = openInputFile(path);
		println(readLine(file));
		closeInputFile(file);

	}

	// method to test if the tape is completely sorted
	private static boolean isSorted(int[] unsorted) {
		for (int i = 0; i < unsorted.length - 1; i++) {
			if (unsorted[i] > unsorted[i + 1]) {
				return false;
			}
		}
		return true;
	}

	// method to merge the values of the tape
	private static void merge() {
		Object file1 = openInputFile("c:\\Band1.txt");
		Object file2 = openInputFile("c:\\Band2.txt");
		Object file = openOutputFile("c:\\"+input);

		int tapeValue1 = 0; // current value of tape 1
		int tapeValue2 = 0; // current value of tape 2
		int prevTapeValue1 = 0; // previous value of tape 1
		int prevTapeValue2 = 0; // previous value of tape 2

		tapeValue1 = readInt(file1);
		tapeValue2 = readInt(file2);

		// till end of file 1 and end of file 2 = true make:
		while (!isEndOfInputFile(file1) || !isEndOfInputFile(file2)) {
			prevTapeValue1 = 0;
			prevTapeValue2 = 0;
			// while not end of run check values and copy the lower one to
			// mergeFile
			while (tapeValue1 > prevTapeValue1 && tapeValue2 > prevTapeValue2) {
				if (tapeValue1 > tapeValue2) {
					print(file, " " + tapeValue2);
					// get the next variable from file 2
					prevTapeValue2 = tapeValue2;
					if (isEndOfInputFile(file2)) {
						while (!isEndOfInputFile(file1)) {
							print(file, " " + tapeValue1);
							tapeValue1 = readInt(file1);
						}
						print(file, " " + tapeValue1);
					} else {
						tapeValue2 = readInt(file2);
					}

				} else {
					print(file, " " + tapeValue1);
					// get the next variable from file 1
					prevTapeValue1 = tapeValue1;
					if (isEndOfInputFile(file1)) {
						while (!isEndOfInputFile(file2)) {
							print(file, " " + tapeValue2);
							tapeValue2 = readInt(file2);
						}
						print(file, " " + tapeValue2);
					} else {
						tapeValue1 = readInt(file1);
					}
				}
			}
			// one run is @ the end!
			// print rest of other run to mergeFile
			if (tapeValue1 < prevTapeValue1) {
				// run1 is @ the end
				while (tapeValue2 > prevTapeValue2 && !isEndOfInputFile(file2)) {
					print(file, " " + tapeValue2);
					// get the next variable from file 2
					prevTapeValue2 = tapeValue2;
					tapeValue2 = readInt(file2);
				}
			}

			if (tapeValue2 < prevTapeValue2) {
				// run2 is @ the end
				while (tapeValue1 > prevTapeValue1 && !isEndOfInputFile(file1)) {
					print(file, " " + tapeValue1);
					// get the next variable from file 1
					prevTapeValue1 = tapeValue1;
					tapeValue1 = readInt(file1);
				}
			}
		}
		closeInputFile(file2);
		closeInputFile(file1);
		closeOutputFile(file);
	}

	public static void split(int[] unsplit) {
		// open files
		Object file1 = openOutputFile("c:\\Band1.txt");
		Object file2 = openOutputFile("c:\\Band2.txt");

		boolean bool = true;
		int lastTapeValue = 0;

		for (int j = 0; j < unsplit.length; j++) {
			if (unsplit[j] >= lastTapeValue) {
				// write in actual tape
				if (bool == true) {
					print(file1, " " + unsplit[j]);
				} else {
					print(file2, " " + unsplit[j]);
				}
			} else {
				// change tape and write in this tape
				if (bool == true) {
					bool = false;
				} else {
					bool = true;
				}
				if (bool == true) {
					print(file1, " " + unsplit[j]);
				} else {
					print(file2, " " + unsplit[j]);
				}
			}
			lastTapeValue = unsplit[j];
		}
		closeOutputFile(file1);
		closeOutputFile(file2);
	}
}
