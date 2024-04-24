package dao;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Regex {
	public boolean regexDiaChi(JTextField txtDiaChi) {
		String input = txtDiaChi.getText().trim();
		String regex = "^([ A-Za-z0-9,\\/.a-zA-ZÃ€ÃÃ‚ÃƒÃˆÃ‰ÃŠÃŒÃÃ’Ã“Ã”Ã•Ã™ÃšÄ‚ÄÄ¨Å¨Æ Ã Ã¡Ã¢Ã£Ã¨Ã©ÃªÃ¬Ã­Ã²Ã³Ã´ÃµÃ¹ÃºÄƒÄ‘Ä©Å©Æ¡Æ¯Ä‚áº áº¢áº¤áº¦áº¨áºªáº¬áº®áº°áº²áº´áº¶áº¸áººáº¼á»€á»€á»‚áº¾Æ°Äƒáº¡áº£áº¥áº§áº©áº«áº­áº¯áº±áº³áºµáº·áº¹áº»áº½á»á»á»ƒáº¿á»„á»†á»ˆá»Šá»Œá»Žá»á»’á»”á»–á»˜á»šá»œá»žá» á»¢á»¤á»¦á»¨á»ªá»…á»‡á»‰á»‹á»á»á»‘á»“á»•á»—á»™á»›á»á»Ÿá»¡á»£á»¥á»§á»©á»«á»¬á»®á»°á»²á»´Ãá»¶á»¸á»­á»¯á»±á»³á»µá»·á»¹]*(\\s?))+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Äá»‹a chá»‰ khÃ´ng há»£p lá»‡!\nMáº«u Ä‘á»‹a chá»‰:56a Cáº§u XÃ©o, TÃ¢n quÃ­, TÃ¢n PhÃº",
					"ThÃ´ng bÃ¡o", JOptionPane.ERROR_MESSAGE);
			txtDiaChi.requestFocus();
			txtDiaChi.selectAll();
			return false;
		} else
			return true;
	}

	public boolean regexTen(JTextField txtTen2) {
		String input = txtTen2.getText().trim();
		String regex = "^([ A-Za-za-zA-ZÃ€ÃÃ‚ÃƒÃˆÃ‰ÃŠÃŒÃÃ’Ã“Ã”Ã•Ã™ÃšÄ‚ÄÄ¨Å¨Æ Ã Ã¡Ã¢Ã£Ã¨Ã©ÃªÃ¬Ã­Ã²Ã³Ã´ÃµÃ¹ÃºÄƒÄ‘Ä©Å©Æ¡Æ¯Ä‚áº áº¢áº¤áº¦áº¨áºªáº¬áº®áº°áº²áº´áº¶áº¸áººáº¼á»€á»€á»‚áº¾Æ°Äƒáº¡áº£áº¥áº§áº©áº«áº­áº¯áº±áº³áºµáº·áº¹áº»áº½á»á»á»ƒáº¿á»„á»†á»ˆá»Šá»Œá»Žá»á»’á»”á»–á»˜á»šá»œá»žá» á»¢á»¤á»¦á»¨á»ªá»…á»‡á»‰á»‹á»á»á»‘á»“á»•á»—á»™á»›á»á»Ÿá»¡á»£á»¥á»§á»©á»«á»¬á»®á»°á»²á»´Ãá»¶á»¸á»­á»¯á»±á»³á»µá»·á»¹]*(\\s?))+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Há» tÃªn khÃ´ng há»£p lá»‡!\nMáº«u há» tÃªn: Nguyá»…n VÄƒn A", "ThÃ´ng bÃ¡o",
					JOptionPane.ERROR_MESSAGE);
			txtTen2.requestFocus();
			txtTen2.selectAll();
			return false;
		} else
			return true;
	}

	public boolean regexSDT(JTextField txtSDT) {
		String input = txtSDT.getText().trim();
		String regex = "^(0[0-9]{9}$)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "SÄT khÃ´ng há»£p lá»‡!\nSÄT gá»“m 10 chá»¯ sá»‘ vÃ  báº¯t Ä‘áº§u báº±ng sá»‘ 0",
					"ThÃ´ng bÃ¡o", JOptionPane.ERROR_MESSAGE);
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		} else
			return true;
	}

	public boolean regexCCCD(JTextField txtCCCD) {
		String input = txtCCCD.getText().trim();
		String regex = "^([0-9]{12}$)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "CCCD khÃ´ng há»£p lá»‡!\nCCCD gá»“m 12 chá»¯ sá»‘", "ThÃ´ng bÃ¡o",
					JOptionPane.ERROR_MESSAGE);
			txtCCCD.requestFocus();
			txtCCCD.selectAll();
			return false;
		} else
			return true;
	}

	public boolean regexSoLuong(JTextField txtSoluong) {
		String input = txtSoluong.getText().trim();
		String regex = "^[1-9]+[0-9]*$";
		if (!input.matches(regex)) {
			JOptionPane.showMessageDialog(null,
					"Sá»‘ lÆ°á»£ng khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng, khÃ´ng Ä‘Æ°á»£c nháº­p chá»¯ vÃ  pháº£i lá»›n hÆ¡n 0\nVÃ­ dá»¥: 10", "ThÃ´ng bÃ¡o",
					JOptionPane.ERROR_MESSAGE);
			txtSoluong.requestFocus();
			txtSoluong.selectAll();
			return false;
		}
		return true;
	}

	public boolean regexGiaP(JTextField txtGiaP) {
		String input = txtGiaP.getText();
		String regex = "^[1-9]+[0-9]*$";
		if (!input.matches(regex)) {
			JOptionPane.showMessageDialog(null,
					"GiÃ¡ phÃ²ng khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng, khÃ´ng Ä‘Æ°á»£c nháº­p chá»¯ vÃ  pháº£i lá»›n hÆ¡n 0\nVÃ­ dá»¥: 1000000", "ThÃ´ng bÃ¡o",
					JOptionPane.ERROR_MESSAGE);
			txtGiaP.requestFocus();
			txtGiaP.selectAll();
			return false;
		}
		return true;
	}
	public boolean regexGiaMH(JTextField txtGiaMH) {
		String input = txtGiaMH.getText();
		String regex = "^[1-9]+[0-9]*$";
		if(!input.matches(regex))
		{	JOptionPane.showMessageDialog(null, "GiÃ¡ máº·t hÃ ng khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng, khÃ´ng Ä‘Æ°á»£c nháº­p chá»¯ vÃ  pháº£i lá»›n hÆ¡n 0\nVÃ­ dá»¥: 10", "ThÃ´ng bÃ¡o", JOptionPane.ERROR_MESSAGE);
			txtGiaMH.requestFocus();
			txtGiaMH.selectAll();
			return false;
		}
		return true;
	}

	public boolean regexTimKiemMaPhong(JTextField txtTim) {
		String input = txtTim.getText();
		String regex = "^((P|p)[0-9]{3})$";
		if (!input.matches(regex)) {
			
			  JOptionPane.showMessageDialog(null,"ThÃ´ng tin tÃ¬m kiáº¿m khÃ´ng há»£p lá»‡\nThÃ´ng tin cÃ³ thá»ƒ tÃ¬m kiáº¿m:\n - MÃ£ PhÃ²ng. VÃ­ dá»¥: P003\n", "ThÃ´ng bÃ¡o", JOptionPane.ERROR_MESSAGE);
			 
			txtTim.requestFocus();
			txtTim.selectAll();
			return false;
		}
		return true;
	}

	public boolean regexTimKiemMaNV(JTextField txtTim) {
		String input = txtTim.getText().trim();
		input = input.toUpperCase();
		String regexMaNV = "^NV[0-9]{3}$";
		if (!input.matches(regexMaNV)) {
			JOptionPane.showMessageDialog(null, "MÃ£ nhÃ¢n viÃªn tÃ¬m kiáº¿m khÃ´ng há»£p lá»‡\nMÃ£ nhÃ¢n viÃªn. VÃ­ dá»¥: NV001\n");
			txtTim.requestFocus();
			txtTim.selectAll();
			return false;
		}
		return true;
	}

	public boolean regexTimNV(JTextField txtTim) {
		String input = txtTim.getText().trim();
		input = input.toUpperCase();
		String regexMaNV = "((NV|nv)[0-9]{3})|";
		String regexTenNV = "([ A-Za-za-zA-ZÃ€ÃÃ‚ÃƒÃˆÃ‰ÃŠÃŒÃÃ’Ã“Ã”Ã•Ã™ÃšÄ‚ÄÄ¨Å¨Æ Ã Ã¡Ã¢Ã£Ã¨Ã©ÃªÃ¬Ã­Ã²Ã³Ã´ÃµÃ¹ÃºÄƒÄ‘Ä©Å©Æ¡Æ¯Ä‚áº áº¢áº¤áº¦áº¨áºªáº¬áº®áº°áº²áº´áº¶áº¸áººáº¼á»€á»€á»‚áº¾Æ°Äƒáº¡áº£áº¥áº§áº©áº«áº­áº¯áº±áº³áºµáº·áº¹áº»áº½á»á»á»ƒáº¿á»„á»†á»ˆá»Šá»Œá»Žá»á»’á»”á»–á»˜á»šá»œá»žá» á»¢á»¤á»¦á»¨á»ªá»…á»‡á»‰á»‹á»á»á»‘á»“á»•á»—á»™á»›á»á»Ÿá»¡á»£á»¥á»§á»©á»«á»¬á»®á»°á»²á»´Ãá»¶á»¸á»­á»¯á»±á»³á»µá»·á»¹]+)|";
		String regexSDT = "(0[0-9]{9})|";
		String regexCa = "([1-3]{1})";
		String regexNV = "^(" + regexMaNV + regexTenNV + regexSDT + regexCa + ")$";
		
		if (!input.matches(regexNV)) {
			JOptionPane.showMessageDialog(null,
					"ThÃ´ng tin tÃ¬m kiáº¿m khÃ´ng há»£p lá»‡!\nThÃ´ng tin cÃ³ thá»ƒ tÃ¬m kiáº¿m:\n - MÃ£ nhÃ¢n viÃªn. VÃ­ dá»¥: NV001 hoáº·c nv001"
							+ "\n - TÃªn nhÃ¢n viÃªn. VÃ­ dá»¥: Tráº§n Thanh Thiá»‡n hoáº·c Thanh Thiá»‡n"
							+ "\n - SÄT gá»“m 10 chá»¯ sá»‘ vÃ  báº¯t Ä‘áº§u báº±ng sá»‘ 0" + "\n - TÃ¬m theo ca: 1, 2, 3",
					"ThÃ´ng bÃ¡o", JOptionPane.ERROR_MESSAGE);
			txtTim.requestFocus();
			txtTim.selectAll();
			return false;
		}
		return true;
	}

	public boolean regexTimKiemMaKH(JTextField txtTK) {
		String input = txtTK.getText().trim();
		input = input.toUpperCase();
		String regexMaKH = "^(KH[0-9]{3})$";
		if (!input.matches(regexMaKH)) {
			JOptionPane.showMessageDialog(null, "MÃ£ khÃ¡ch hÃ ng khÃ´ng há»£p lá»‡!\n - VÃ­ dá»¥ mÃ£ khÃ¡ch hÃ ng: KH001");
			txtTK.requestFocus();
			txtTK.selectAll();
			return false;
		}
		return true;
	}

	public boolean regexTimKiemLoaiKH(JTextField txtTK) {
		String in = txtTK.getText().toLowerCase().trim();

		String regexThuong = "^[khÃ¡ch hÃ ng thÆ°á»ng]*+$";
		Pattern patternThuong = Pattern.compile(regexThuong);
		Matcher matcherThuong = patternThuong.matcher(in);

		String regexMember = "^[thÃ nh viÃªn thÆ°á»ng]*+$";
		Pattern patternMember = Pattern.compile(regexMember);
		Matcher matcherMember = patternMember.matcher(in);

		String regexVip = "^[thÃ nh viÃªn vip]*+$";
		Pattern patternVip = Pattern.compile(regexVip);
		Matcher matcherVip = patternVip.matcher(in);

		String regexStop = "^[khÃ´ng cÃ²n lÃ  khÃ¡ch hÃ ng]*+$";
		Pattern patternStop = Pattern.compile(regexStop);
		Matcher matcherStop = patternStop.matcher(in);

		if (!matcherThuong.find() && !matcherMember.find() && !matcherVip.find() && !matcherStop.find()) {
			txtTK.requestFocus();
			txtTK.selectAll();
			return false;
		} else
			return true;
	}
	public boolean regexTenMH(JTextField txtTen2) {
		String input = txtTen2.getText().trim();
		String regex = "^([ A-Za-za-zA-ZÃ€ÃÃ‚ÃƒÃˆÃ‰ÃŠÃŒÃÃ’Ã“Ã”Ã•Ã™ÃšÄ‚ÄÄ¨Å¨Æ Ã Ã¡Ã¢Ã£Ã¨Ã©ÃªÃ¬Ã­Ã²Ã³Ã´ÃµÃ¹ÃºÄƒÄ‘Ä©Å©Æ¡Æ¯Ä‚áº áº¢áº¤áº¦áº¨áºªáº¬áº®áº°áº²áº´áº¶áº¸áººáº¼á»€á»€á»‚áº¾Æ°Äƒáº¡áº£áº¥áº§áº©áº«áº­áº¯áº±áº³áºµáº·áº¹áº»áº½á»á»á»ƒáº¿á»„á»†á»ˆá»Šá»Œá»Žá»á»’á»”á»–á»˜á»šá»œá»žá» á»¢á»¤á»¦á»¨á»ªá»…á»‡á»‰á»‹á»á»á»‘á»“á»•á»—á»™á»›á»á»Ÿá»¡á»£á»¥á»§á»©á»«á»¬á»®á»°á»²á»´Ãá»¶á»¸á»­á»¯á»±á»³á»µá»·á»¹]*(\\s?))+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "TÃªn khÃ´ng há»£p lá»‡!\nMáº«u tÃªn: Bia Heniken, trÃ¡i cÃ¢y,...", "ThÃ´ng bÃ¡o",
					JOptionPane.ERROR_MESSAGE);
			txtTen2.requestFocus();
			txtTen2.selectAll();
			return false;
		} else
			return true;
		}
	public boolean regexTimMH(JTextField txtTen2) {
		String input = txtTen2.getText();
		String regex = "^([ A-Za-za-zA-ZÃ€ÃÃ‚ÃƒÃˆÃ‰ÃŠÃŒÃÃ’Ã“Ã”Ã•Ã™ÃšÄ‚ÄÄ¨Å¨Æ Ã Ã¡Ã¢Ã£Ã¨Ã©ÃªÃ¬Ã­Ã²Ã³Ã´ÃµÃ¹ÃºÄƒÄ‘Ä©Å©Æ¡Æ¯Ä‚áº áº¢áº¤áº¦áº¨áºªáº¬áº®áº°áº²áº´áº¶áº¸áººáº¼á»€á»€á»‚áº¾Æ°Äƒáº¡áº£áº¥áº§áº©áº«áº­áº¯áº±áº³áºµáº·áº¹áº»áº½á»á»á»ƒáº¿á»„á»†á»ˆá»Šá»Œá»Žá»á»’á»”á»–á»˜á»šá»œá»žá» á»¢á»¤á»¦á»¨á»ªá»…á»‡á»‰á»‹á»á»á»‘á»“á»•á»—á»™á»›á»á»Ÿá»¡á»£á»¥á»§á»©á»«á»¬á»®á»°á»²á»´Ãá»¶á»¸á»­á»¯á»±á»³á»µá»·á»¹]*(\\s?))+$";
		if (input.matches(regex)) {
			JOptionPane.showMessageDialog(null,
					"ThÃ´ng tin tÃ¬m kiáº¿m khÃ´ng há»£p lá»‡!\nThÃ´ng tin cÃ³ thá»ƒ tÃ¬m kiáº¿m:\n - TÃªn máº·t hÃ ng. VÃ­ dá»¥: Bia Heiniken,..."
							+ "\n - Loáº¡i máº·t hÃ ng. VÃ­ dá»¥: NÆ°á»›c uá»‘ng, Ä‘á»“ Äƒn.",
					"ThÃ´ng bÃ¡o", JOptionPane.ERROR_MESSAGE);
			txtTen2.requestFocus();
			txtTen2.selectAll();
			return false;
		} else
			return true;

	}

	@SuppressWarnings("deprecation")
	public boolean regexNVTren18(JDateChooser dateChooser) {
		LocalDate dNow = LocalDate.now();
		int nam = dNow.getYear();
		int day = dateChooser.getDate().getDay();
		int monnth = dateChooser.getDate().getMonth();
		int year = dateChooser.getDate().getYear();
		if (day <= 0 || day > 31 || monnth <= 0 || monnth > 12 || year <= 0 || year > (nam - 18)) {
			JOptionPane.showMessageDialog(null, "NhÃ¢n viÃªn pháº£i trÃªn 18 tuá»•i!", "ThÃ´ng bÃ¡o", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public boolean regexTimDSHD(JTextField txtDSHD) {
		String input = txtDSHD.getText().toString().trim();
		input = input.toUpperCase();
		String regexMaNV = "^((NV|nv)[0-9]{3})|([ A-Za-za-zA-ZÃ€ÃÃ‚ÃƒÃˆÃ‰ÃŠÃŒÃÃ’Ã“Ã”Ã•Ã™ÃšÄ‚ÄÄ¨Å¨Æ Ã Ã¡Ã¢Ã£Ã¨Ã©ÃªÃ¬Ã­Ã²Ã³Ã´ÃµÃ¹ÃºÄƒÄ‘Ä©Å©Æ¡Æ¯Ä‚áº áº¢áº¤áº¦áº¨áºªáº¬áº®áº°áº²áº´áº¶áº¸áººáº¼á»€á»€á»‚áº¾Æ°Äƒáº¡áº£áº¥áº§áº©áº«áº­áº¯áº±áº³áºµáº·áº¹áº»áº½á»á»á»ƒáº¿á»„á»†á»ˆá»Šá»Œá»Žá»á»’á»”á»–á»˜á»šá»œá»žá» á»¢á»¤á»¦á»¨á»ªá»…á»‡á»‰á»‹á»á»á»‘á»“á»•á»—á»™á»›á»á»Ÿá»¡á»£á»¥á»§á»©á»«á»¬á»®á»°á»²á»´Ãá»¶á»¸á»­á»¯á»±á»³á»µá»·á»¹]+)$";
		if (!input.matches(regexMaNV)) {
			JOptionPane.showMessageDialog(null,
					"ThÃ´ng tin tÃ¬m kiáº¿m khÃ´ng há»£p lá»‡!\nThÃ´ng tin cÃ³ thá»ƒ tÃ¬m kiáº¿m:\n - MÃ£ nhÃ¢n viÃªn VÃ­ dá»¥: NV001\n - TÃªn KhÃ¡ch hÃ ng VÃ­ dá»¥ Há»£p hoáº·c Nguyá»…n Thá»‹ BÃ­ch Há»£p...");
			txtDSHD.requestFocus();
			txtDSHD.selectAll();
			return false;
		}
		return true;
	}

	@SuppressWarnings("deprecation")
	public boolean regexMatKhau(JPasswordField pwMK) {
		String input = pwMK.getText().toString().trim();
		String regexMaNV = "^[A-Z][a-zA-Z0-9 ]{5,}$";
		if (!input.matches(regexMaNV)) {
			JOptionPane.showMessageDialog(null,
					"Máº­t kháº©u khÃ´ng há»£p lá»‡\nMáº­t kháº©u há»£p lá»‡:\n - KÃ­ tá»± Ä‘áº§u tiÃªn lÃ  chá»¯ viáº¿t hoa.\n - CÃ³ Ã­t nháº¥t 6 kÃ­ tá»±, chá»‰ chá»©a chá»¯, sá»‘, vÃ  khoáº£ng tráº¯ng.\nVÃ­ dá»¥: T123abc hoáº·c DangNhap123");
			pwMK.requestFocus();
			pwMK.selectAll();
			return false;
		}
		return true;
	}


	public boolean regexTimKiemLoaiMatHang(JTextField ten) {
		String in = ten.getText().toLowerCase().trim();

		String regexDA = "^[Ä‘á»“ Äƒn]*+$";
		Pattern patternDA = Pattern.compile(regexDA);
		Matcher matcherDA = patternDA.matcher(in);

		String regexDU = "^[Ä‘á»“ uá»‘ng]*+$";
		Pattern patternDU = Pattern.compile(regexDU);
		Matcher matcherDU = patternDU.matcher(in);

		String regexKhac = "^[khÃ¡c]*+$";
		Pattern patternKhac = Pattern.compile(regexKhac);
		Matcher matcherKhac = patternKhac.matcher(in);

		String regexStop = "^[ngá»«ng kinh doanh]*+$";
		Pattern patternStop = Pattern.compile(regexStop);
		Matcher matcherStop = patternStop.matcher(in);
		
		if (!matcherDA.find() && !matcherDU.find() && !matcherKhac.find() && !matcherStop.find()) {
			ten.requestFocus();
			ten.selectAll();
			return false;
		} else
			return true;
	}

	public boolean regexTimKiemGioiTinh(JTextField txtTim) {
		String input = txtTim.getText();
		String regexNam = "^[nam]$";
		String regexNu = "^[ná»¯]$";
		Pattern patternNam = Pattern.compile(regexNam);
		Matcher matcherNam = patternNam.matcher(input);
		if (!matcherNam.find()) {
			JOptionPane.showMessageDialog(null, "Giá»›i tÃ­nh khÃ´ng há»£p lá»‡!\nTÃ¬m giá»›i tÃ­nh: nam hoáº·c ná»¯", "ThÃ´ng bÃ¡o",
					JOptionPane.ERROR_MESSAGE);
			txtTim.requestFocus();
			txtTim.selectAll();
			return false;
		}

		Pattern patternNu = Pattern.compile(regexNu);
		Matcher matcherNu = patternNu.matcher(input);
		if (!matcherNu.find()) {
			JOptionPane.showMessageDialog(null, "Giá»›i tÃ­nh khÃ´ng há»£p lá»‡!\nTÃ¬m giá»›i tÃ­nh: nam hoáº·c ná»¯", "ThÃ´ng bÃ¡o",
					JOptionPane.ERROR_MESSAGE);
			txtTim.requestFocus();
			txtTim.selectAll();
			return false;
		}
		return true;
	}
	
	public boolean regexTimKH(JTextField txtTK) {
		String input = txtTK.getText().trim();
		input = input.toUpperCase();
		String regexMaKH = "((KH|kh)[0-9]{3})|";
		String regexTenKH = "([ A-Za-za-zA-ZÃ€ÃÃ‚ÃƒÃˆÃ‰ÃŠÃŒÃÃ’Ã“Ã”Ã•Ã™ÃšÄ‚ÄÄ¨Å¨Æ Ã Ã¡Ã¢Ã£Ã¨Ã©ÃªÃ¬Ã­Ã²Ã³Ã´ÃµÃ¹ÃºÄƒÄ‘Ä©Å©Æ¡Æ¯Ä‚áº áº¢áº¤áº¦áº¨áºªáº¬áº®áº°áº²áº´áº¶áº¸áººáº¼á»€á»€á»‚áº¾Æ°Äƒáº¡áº£áº¥áº§áº©áº«áº­áº¯áº±áº³áºµáº·áº¹áº»áº½á»á»á»ƒáº¿á»„á»†á»ˆá»Šá»Œá»Žá»á»’á»”á»–á»˜á»šá»œá»žá» á»¢á»¤á»¦á»¨á»ªá»…á»‡á»‰á»‹á»á»á»‘á»“á»•á»—á»™á»›á»á»Ÿá»¡á»£á»¥á»§á»©á»«á»¬á»®á»°á»²á»´Ãá»¶á»¸á»­á»¯á»±á»³á»µá»·á»¹]+)|";
		String regexSDT = "(0[0-9]{9})";
		String regexKH = "^(" + regexMaKH + regexTenKH + regexSDT+ ")$";
		if (!input.matches(regexKH)) {
			JOptionPane.showMessageDialog(null,
					"ThÃ´ng tin tÃ¬m kiáº¿m khÃ´ng há»£p lá»‡!\nThÃ´ng tin cÃ³ thá»ƒ tÃ¬m kiáº¿m:\n - MÃ£ khÃ¡ch hÃ ng. VÃ­ dá»¥: KH001 hoáº·c kh001"
							+ "\n - TÃªn khÃ¡ch hÃ ng. VÃ­ dá»¥: Tráº§n Thanh Thiá»‡n..."
							+ "\n - SÄT gá»“m 10 chá»¯ sá»‘ vÃ  báº¯t Ä‘áº§u báº±ng sá»‘ 0",
					"ThÃ´ng bÃ¡o", JOptionPane.ERROR_MESSAGE);
			txtTK.requestFocus();
			txtTK.selectAll();
			return false;
		}
		return true;
	}
	
	public boolean regexTimPhong(JTextField txtTK) {
		String input = txtTK.getText().trim();
		input = input.toUpperCase();
		String regexMaP = "((P|p)[0-9]{3})|";
		String regexTen = "([ A-Za-za-zA-ZÃ€ÃÃ‚ÃƒÃˆÃ‰ÃŠÃŒÃÃ’Ã“Ã”Ã•Ã™ÃšÄ‚ÄÄ¨Å¨Æ Ã Ã¡Ã¢Ã£Ã¨Ã©ÃªÃ¬Ã­Ã²Ã³Ã´ÃµÃ¹ÃºÄƒÄ‘Ä©Å©Æ¡Æ¯Ä‚áº áº¢áº¤áº¦áº¨áºªáº¬áº®áº°áº²áº´áº¶áº¸áººáº¼á»€á»€á»‚áº¾Æ°Äƒáº¡áº£áº¥áº§áº©áº«áº­áº¯áº±áº³áºµáº·áº¹áº»áº½á»á»á»ƒáº¿á»„á»†á»ˆá»Šá»Œá»Žá»á»’á»”á»–á»˜á»šá»œá»žá» á»¢á»¤á»¦á»¨á»ªá»…á»‡á»‰á»‹á»á»á»‘á»“á»•á»—á»™á»›á»á»Ÿá»¡á»£á»¥á»§á»©á»«á»¬á»®á»°á»²á»´Ãá»¶á»¸á»­á»¯á»±á»³á»µá»·á»¹]+)|";
		String regexPhong = "^(" + regexMaP + regexTen +  ")$";
		if (!input.matches(regexPhong)) {
			JOptionPane.showMessageDialog(null,
					"ThÃ´ng tin tÃ¬m kiáº¿m khÃ´ng há»£p lá»‡!\nThÃ´ng tin cÃ³ thá»ƒ tÃ¬m kiáº¿m:\n - MÃ£ phÃ²ng. VÃ­ dá»¥: P001 hoáº·c p001"
							+ "\n - Loáº¡i phÃ²ng. VÃ­ dá»¥: PhÃ²ng thÆ°á»ng, trung, VIP, ngá»«ng hoáº¡t Ä‘á»™ng."
							+ "\n - TÃ¬nh tráº¡ng. VÃ­ dá»¥: Trá»‘ng, Ä‘Ã£ Ä‘áº·t, Ä‘ang sá»­ dá»¥ng.",
					"ThÃ´ng bÃ¡o", JOptionPane.ERROR_MESSAGE);
			txtTK.requestFocus();
			txtTK.selectAll();
			return false;
		}
		return true;
	}

	public boolean regexTimKiemLoaiPhong(JTextField txtTK) {
		String in = txtTK.getText().toLowerCase().trim();

		String regexThuong = "^[phÃ²ng thÆ°á»ng]*+$";
		Pattern patternThuong = Pattern.compile(regexThuong);
		Matcher matcherThuong = patternThuong.matcher(in);

		String regexMember = "^[phÃ²ng trung]*+$";
		Pattern patternMember = Pattern.compile(regexMember);
		Matcher matcherMember = patternMember.matcher(in);

		String regexVip = "^[phÃ²ng vip]*+$";
		Pattern patternVip = Pattern.compile(regexVip);
		Matcher matcherVip = patternVip.matcher(in);

		String regexStop = "^[ngá»«ng hoáº¡t Ä‘á»™ng]*+$";
		Pattern patternStop = Pattern.compile(regexStop);
		Matcher matcherStop = patternStop.matcher(in);

		if (!matcherThuong.find() && !matcherMember.find() && !matcherVip.find() && !matcherStop.find()) {
			txtTK.requestFocus();
			txtTK.selectAll();
			return false;
		} else
			return true;
	}
	
	public boolean regexTimKiemTinhTrang(JTextField txtTK) {
		String in = txtTK.getText().toLowerCase().trim();

		String regexTrong = "^[trá»‘ng]*+$";
		Pattern patternTrong = Pattern.compile(regexTrong);
		Matcher matcherTrong = patternTrong.matcher(in);

		String regexDaDat = "^[Ä‘Ã£ Ä‘áº·t]*+$";
		Pattern patternDaDat = Pattern.compile(regexDaDat);
		Matcher matcherDaDat = patternDaDat.matcher(in);

		String regexUsing = "^[Ä‘ang hoáº¡t Ä‘á»™ng]*+$";
		Pattern patternUsing = Pattern.compile(regexUsing);
		Matcher matcherUsing = patternUsing.matcher(in);


		if (!matcherTrong.find() && !matcherDaDat.find() && !matcherUsing.find() ) {
			txtTK.requestFocus();
			txtTK.selectAll();
			return false;
		} else
			return true;
	}
	
	public boolean regexTimDDPTheoKH(JTextField txtTK) {
		String input = txtTK.getText().trim();
		input = input.toUpperCase();
		String regexTenKH = "([ A-Za-za-zA-ZÃ€ÃÃ‚ÃƒÃˆÃ‰ÃŠÃŒÃÃ’Ã“Ã”Ã•Ã™ÃšÄ‚ÄÄ¨Å¨Æ Ã Ã¡Ã¢Ã£Ã¨Ã©ÃªÃ¬Ã­Ã²Ã³Ã´ÃµÃ¹ÃºÄƒÄ‘Ä©Å©Æ¡Æ¯Ä‚áº áº¢áº¤áº¦áº¨áºªáº¬áº®áº°áº²áº´áº¶áº¸áººáº¼á»€á»€á»‚áº¾Æ°Äƒáº¡áº£áº¥áº§áº©áº«áº­áº¯áº±áº³áºµáº·áº¹áº»áº½á»á»á»ƒáº¿á»„á»†á»ˆá»Šá»Œá»Žá»á»’á»”á»–á»˜á»šá»œá»žá» á»¢á»¤á»¦á»¨á»ªá»…á»‡á»‰á»‹á»á»á»‘á»“á»•á»—á»™á»›á»á»Ÿá»¡á»£á»¥á»§á»©á»«á»¬á»®á»°á»²á»´Ãá»¶á»¸á»­á»¯á»±á»³á»µá»·á»¹]+)|";
		String regexSDT = "(0[0-9]{9})";
		String regexKH = "^(" + regexTenKH + regexSDT+ ")$";
		if (!input.matches(regexKH)) {
			JOptionPane.showMessageDialog(null,
					"ThÃ´ng tin tÃ¬m kiáº¿m khÃ´ng há»£p lá»‡!\nThÃ´ng tin cÃ³ thá»ƒ tÃ¬m kiáº¿m:"
							+ "\n - TÃªn khÃ¡ch hÃ ng. VÃ­ dá»¥: Tráº§n Thanh TÃ¢m hoáº·c Thanh TÃ¢m"
							+ "\n - SÄT gá»“m 10 chá»¯ sá»‘ vÃ  báº¯t Ä‘áº§u báº±ng sá»‘ 0",
					"ThÃ´ng bÃ¡o", JOptionPane.ERROR_MESSAGE);
			txtTK.requestFocus();
			txtTK.selectAll();
			return false;
		}
		return true;
	}

}
