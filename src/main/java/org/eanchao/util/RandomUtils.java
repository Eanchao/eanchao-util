package org.eanchao.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * 随机生成工具<br>
 * Random Generator
 * 
 * <pre>
 * 本工具类包含以下功能：
 * 1、随机生成姓名(lineName)
 * 2、随机生成姓(getFirstName)
 * 3、随机生成名(getLastName)
 * 4、随机生成企业码(getCompanyCode)
 * 5、随机生成公司名(生成随机公司名称)
 * 6、随机生成UUID(getUUIDString)
 * 7、随机生成任意长度的数值(getRandomNumber)
 * 8、随机生成不小于N的整数(getRandomInt)
 * </pre>
 * 
 * @author Eanchao
 *
 */
public class RandomUtils {

	private static RandomUtils randomName = new RandomUtils();

	private static String language = "Other";

	private static boolean gender = true;

	private static boolean hasMiddle = false;

	private static boolean isTwo = false;

	protected static RandomUtils getRandomName() {
		return randomName;
	}

	protected static void setRandomName(RandomUtils randomName) {
		RandomUtils.randomName = randomName;
	}

	protected static String getLanguage() {
		return language;
	}

	protected static void setLanguage(String language) {
		RandomUtils.language = language;
	}

	protected static boolean isGender() {
		return gender;
	}

	protected static void setGender(boolean gender) {
		RandomUtils.gender = gender;
	}

	protected static boolean isHasMiddle() {
		return hasMiddle;
	}

	protected static void setHasMiddle(boolean hasMiddle) {
		RandomUtils.hasMiddle = hasMiddle;
	}

	protected static boolean isTwo() {
		return isTwo;
	}

	protected static void setTwo(boolean isTwo) {
		RandomUtils.isTwo = isTwo;
	}

	protected static String getZh_CN_firstname() {
		return zh_CN_firstname;
	}

	protected static void setZh_CN_firstname(String zh_CN_firstname) {
		RandomUtils.zh_CN_firstname = zh_CN_firstname;
	}

	protected static String getZh_CN_mensinglelastname() {
		return zh_CN_mensinglelastname;
	}

	protected static void setZh_CN_mensinglelastname(String zh_CN_mensinglelastname) {
		RandomUtils.zh_CN_mensinglelastname = zh_CN_mensinglelastname;
	}

	protected static String getZh_CN_womensinglelastname() {
		return zh_CN_womensinglelastname;
	}

	protected static void setZh_CN_womensinglelastname(String zh_CN_womensinglelastname) {
		RandomUtils.zh_CN_womensinglelastname = zh_CN_womensinglelastname;
	}

	protected static String getZh_CN_mendoublelastname() {
		return zh_CN_mendoublelastname;
	}

	protected static void setZh_CN_mendoublelastname(String zh_CN_mendoublelastname) {
		RandomUtils.zh_CN_mendoublelastname = zh_CN_mendoublelastname;
	}

	protected static String getZh_CN_womendoublelastname() {
		return zh_CN_womendoublelastname;
	}

	protected static void setZh_CN_womendoublelastname(String zh_CN_womendoublelastname) {
		RandomUtils.zh_CN_womendoublelastname = zh_CN_womendoublelastname;
	}

	protected static String getEn_US_firstname() {
		return en_US_firstname;
	}

	protected static void setEn_US_firstname(String en_US_firstname) {
		RandomUtils.en_US_firstname = en_US_firstname;
	}

	protected static String getEn_US_menlastname() {
		return en_US_menlastname;
	}

	protected static void setEn_US_menlastname(String en_US_menlastname) {
		RandomUtils.en_US_menlastname = en_US_menlastname;
	}

	protected static String getEn_US_womenlastname() {
		return en_US_womenlastname;
	}

	protected static void setEn_US_womenlastname(String en_US_womenlastname) {
		RandomUtils.en_US_womenlastname = en_US_womenlastname;
	}

	protected static String getEn_US_middlename() {
		return en_US_middlename;
	}

	protected static void setEn_US_middlename(String en_US_middlename) {
		RandomUtils.en_US_middlename = en_US_middlename;
	}

	// zh_CN
	private static String zh_CN_firstname = "csv/zh_CN/firstname.csv";
	private static String zh_CN_mensinglelastname = "csv/zh_CN/mensinglelastname.csv";
	private static String zh_CN_womensinglelastname = "csv/zh_CN/womensinglelastname.csv";
	private static String zh_CN_mendoublelastname = "csv/zh_CN/mendoublelastname.csv";
	private static String zh_CN_womendoublelastname = "csv/zh_CN/womendoublelastname.csv";

	// en_US
	private static String en_US_firstname = "csv/en_US/firstname.csv";
	private static String en_US_menlastname = "csv/en_US/menlastname.csv";
	private static String en_US_womenlastname = "csv/en_US/womenlastname.csv";
	private static String en_US_middlename = "csv/en_US/middlename.csv";

	/**
	 * 创建UUID字符串
	 * @return
	 */
	public static String getUUIDString() {
		String uuid=UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
	
	private static long count = 1;

	/**
	 * 产生小于输入值的随机整数
	 * 
	 * @param integer
	 * @return
	 */
	public static int getRandomInt(int integer) {
		Random random = new Random();
		int randomInteger = random.nextInt(integer);
		return randomInteger;
	}

	/**
	 * 随机生成任意长度的数字
	 * 
	 * @param num
	 * @return
	 */
	public static long getRandomNumber(int num) {
		double random = Math.random();
		for (int i = 0; i < num; i++) {
			count *= 10;
		}
		return (long) (random * count);
	}

	/**
	 * 生成随机码
	 * 
	 * @param startNumber  企业码前缀
	 * @param k产生k位随机整数字符串
	 * @return
	 */
	public static String getCompanyCode(String startNumber, int k) {
		StringBuffer buffer = new StringBuffer();
		int num[] = new int[k];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (10 * (Math.random()));
			buffer.append(num[i]);
		}
		return startNumber + buffer.toString();
	}

	/**
	 * 生成随机公司名称
	 * 
	 * @param startName:公司名称前缀
	 * @param min:汉字数量最小值
	 * @param max:汉字数量最大值
	 * @param endNames:存放公司类型数组
	 * @return
	 */
	public static String getCompanyName(String startName, int min, int max, String endNames[]) {
		String centerName = RandomUtils.randomChineseString(min, max);
		Random random = new Random();
		int index = random.nextInt(endNames.length); // 0<=index<3
		String endName = endNames[index];
		String name = startName + centerName + endName;
		return name;
	}

	/**
	 * 产生给定范围个数的汉字
	 * 
	 * @param min 最小汉字数
	 * @param max 最大汉字数
	 * @return
	 */
	public static String randomChineseString(int min, int max) {

		Random rand = new Random();
		int count = rand.nextInt(max - min + 1) + min;

		String name = "";
		int chineseNameNum = count;
		for (int i = 1; i <= chineseNameNum; i++) {
			name += new RandomUtils().getChinese();
		}
		return name;
	}

	/**
	 * 获取单个中文字符
	 * 
	 * @return
	 */
	public String getChinese() {
		String chinese = "";
		int i = (int) (Math.random() * 40 + 16);
		int j = (int) (Math.random() * 94 + 1);
		if (i == 55) {
			j = (int) (Math.random() * 89 + 1);
		}
		byte[] bytes = { (byte) (i + 160), (byte) (j + 160) };
		try {
			chinese = new String(bytes, "gb2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return chinese;
	}

	/**
	 * 随机生成姓氏<br>
	 * Random Firstname
	 * 
	 * <pre>
	 * 本方法可以通过参数设定要随机生成的姓氏语种
	 * This method can select random firstname languages by parameter
	 * 	-> zh_CN	简体中文 (中国)
	 * 	-> en_US	English (United States)
	 * </pre>
	 * 
	 * @param language
	 * @return
	 * @throws IOException
	 * @throws ConfigurationFileException
	 */
	public static String getFirstName(String language) throws IOException {
		if (language.equals("zh_CN")) {
			return randomName.FirstName_zh_CN(zh_CN_firstname);
		} else if (language.equals("en_US")) {
			return randomName.FirstName_en_US(en_US_firstname);
		} else {
			return "无效的执行";
		}
	}

	/**
	 * 随机生成名<br>
	 * Random Lastname
	 * 
	 * <pre>
	 * 本方法可以通过参数设定要随机生成的名字及性别的语种
	 * This method can select random lastname and gender languages by parameters
	 * 	-> zh_CN	简体中文 (中国)
	 * 	-> en_US	English (United States / United Kingdom)
	 * </pre>
	 * 
	 * @param language
	 * @param gender
	 * @return
	 * @throws IOException
	 */
	public static String getLastName(String language, boolean gender, boolean hasMiddle, boolean isTwo)
			throws IOException {
		if (gender) {
			if (language.equals("zh_CN")) {
				if (isTwo) {
					return randomName.LastName_zh_CN(zh_CN_mendoublelastname);
				} else {
					return randomName.LastName_zh_CN(zh_CN_mensinglelastname);
				}
			} else if (language.equals("en_US")) {
				return randomName.LastName_en_US(en_US_menlastname, hasMiddle, isTwo);
			} else {
				return "无效的执行";
			}
		} else {
			if (language.equals("zh_CN")) {
				if (isTwo) {
					return randomName.LastName_zh_CN(zh_CN_womendoublelastname);
				} else {
					return randomName.LastName_zh_CN(zh_CN_womensinglelastname);
				}
			} else if (language.equals("en_US")) {
				return randomName.LastName_en_US(en_US_womenlastname, hasMiddle, isTwo);
			} else {
				return "无效的执行";
			}
		}

	}

	/**
	 * 随机生成姓氏（中文）
	 * 
	 * @return
	 * @throws IOException
	 */
	private String FirstName_zh_CN(String csvpath) throws IOException {
		List<String> names = randomName.getBufferedReader(csvpath);
		int num = getNum(4, names.size());
		return names.get(num);
	}

	/**
	 * 随机生成姓氏（英文）
	 * 
	 * @return
	 * @throws IOException
	 */
	private String FirstName_en_US(String csvpath) throws IOException {
		List<String> names = randomName.getBufferedReader(csvpath);
		int num = getNum(4, names.size());
		return names.get(num);
	}

	/**
	 * 随机生成姓名（中文）
	 * 
	 * @param gender -> true : 男（默认值）false : 女
	 * @return
	 * @throws IOException
	 */
	private String LastName_zh_CN(String csvpath) throws IOException {
		if (gender == true) {
			List<String> names = randomName.getBufferedReader(csvpath);
			int num = getNum(4, names.size());
			return names.get(num);
		} else if (gender == false) {
			List<String> names = randomName.getBufferedReader(csvpath);
			int num = getNum(4, names.size());
			return names.get(num);
		} else {
			return "";
		}
	}

	/**
	 * 随机生成姓名（英文）
	 * 
	 * <pre>
	 * 声明：
	 * 由于字符限制，中文单文字限制，随机值最大不可超过60个，双字中文不可超过500个
	 * 英文不可超过600个，带有中间姓不可超过50个
	 * </pre>
	 * 
	 * @param gender    -> true : 男（默认值） / false : 女
	 * @param hasMiddle -> true : 包含中间名 / false : 不包含中间名（默认值）
	 * @return 教名(名字) 中间名(如果可行)
	 * @throws IOException
	 */
	private String LastName_en_US(String csvpath, boolean hasMiddle, boolean isTwo) throws IOException {
		if (hasMiddle) {
			List<String> names = randomName.getBufferedReader(csvpath);
			List<String> midnames = randomName.getBufferedReader(en_US_middlename);
			int num = getNum(4, names.size());
			int midnum = getNum(4, midnames.size());
			String name = names.get(num) + " " + midnames.get(midnum);
			return name;
		} else {
			List<String> names = randomName.getBufferedReader(csvpath);
			int num = getNum(4, names.size());
			return names.get(num);
		}

	}

	/**
	 * 获取随机值
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	private static int getNum(int start, int end) {
		return (int) (Math.random() * (end - start + 1) + start);
	}

	/**
	 * 随机生成多个姓名
	 * 
	 * <pre>
	 * 声明：
	 * 由于字符限制，中文单文字限制，随机值最大不可超过60个，双字中文不可超过500个
	 * 英文不可超过600个，带有中间姓不可超过50个
	 * </pre>
	 * 
	 * @param index
	 * @param sex
	 * @return
	 * @throws IOException
	 */
	public static List<String> lineName(int index, boolean gender, String language, boolean hasMiddle, boolean isTwo)
			throws IOException {
		List<String> nameList = new ArrayList<String>();
		if (language.equals("en_US")) {
			for (int i = 0; i < index; i++) {
				nameList.add(RandomUtils.getFirstName(language) + " "
						+ RandomUtils.getLastName(language, gender, hasMiddle, isTwo));
			}
			return nameList;
		}
		for (int i = 0; i < index; i++) {
			nameList.add(
					RandomUtils.getFirstName(language) + RandomUtils.getLastName(language, gender, hasMiddle, isTwo));
		}
		return nameList;
	}

	/**
	 * 获取数据CSV文件
	 * 
	 * @param csvpath
	 * @return
	 * @throws IOException
	 */
	private List<String> getBufferedReader(String csvpath) throws IOException {
		Class<? extends RandomUtils> randomNameClass = randomName.getClass();
		ClassLoader classLoader = randomNameClass.getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(csvpath);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		List<String> names = new ArrayList<String>();
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			names.add(line);
		}
		return names;
	}

}
