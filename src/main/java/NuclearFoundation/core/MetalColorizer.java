package NuclearFoundation.core;

public class MetalColorizer {
	
	public static int getColorForMetal(String metal){
		switch(metal){
		case("Boron"):return 0x808080;
		case("Aluminium"):return 0xeeeeee;
		case("Titanium"):return 0x292929;
		case("Chromium"):return 0xe78686;
		case("Iron"):return 0xffffff;
		case("Cobalt"):return 0x9497d9;
		case("Nickel"):return 0xfffeb5;
		case("Copper"):return 0xff8e2b;
		case("Zinc"):return 0xffffd9;
		case("Zirconium"):return 0x80e9df;
		case("Silver"):return 0xD1FFFC;
		case("Tin"):return 0xebebeb;
		case("Wolfram"):return 0x292929;
		case("Osmium"):return 0x9fd9bc;
		case("Platinum"):return 0xffffff;
		case("Gold"):return 0xffff0b;
		case("Lead"):return 0x7480a3;
		case("Bismuth"):return 0x228E98;
		case("Thorium"):return 0x373e4f;
		case("Uranium"):return 0x218a2c;
		case("Mithril"):return 0xD1FFFC;
		case("Adamantine"):return 0xeeeeee;
		case("Prometheum"):return 0x165f1e;
		case("Orichalcum"):return 0xff8e2b;
		case("Blazonium"):return 0xfa7420;
		case("Terminium"):return 0x007856;
		case("Duraluminium"):return 0xeeeeee;
		case("Alumite"):return 0xffa3f7;
		case("PigIron"):return 0xa99faa;
		case("Steel"):return 0x808080;
		case("StainlessSteel"):return 0xc0c0c0;
		case("DamascusSteel"):return 0x856255;
		case("BlackSteel"):return 0x1b1b1b;
		case("TearSteel"):return 0x808080;
		case("RedSteel"):return 0xff0000;
		case("BlueSteel"):return 0x1111ff;
		case("Stellite"):return 0x736d82;
		case("Hastelloy"):return 0x808080;
		case("Alnico"):return 0x808080;
		case("Invar"):return 0xb4b4b4;
		case("Brass"):return 0xffe945;
		case("AluminiumBrass"):return 0xfbff65;
		case("BismuthBrass"):return 0x67b475;
		case("Bronze"):return 0xFFCB00;
		case("BlackBronze"):return 0x6c4266;
		case("MithrilBronze"):return 0xD1FFFC;
		case("Signalum"):return 0xFF4E00;
		case("Vibranium"):return 0x6cc978;
		case("Electrum"):return 0xffe945;
		case("SterlingSilver"):return 0xebcc93;
		case("Lumium"):return 0xfbff65;
		case("Enderium"):return 0x0E5B5B;
		case("Teslium"):return 0x55cfff;
		case("TungstenSteel"):return 0x292929;
		case("RoseGold"):return 0xf1c4c4;
		case("Nichrome"):return 0xfffce1;
		case("Arsenic"):return 0x909090;
		case("RedNik"):return 0xff00ff;
		case("WeakAlumite"):return 0xffa3f7;
		case("WeakStainlessSteel"):return 0xc0c0c0;
		case("WeakBlackSteel"):return 0x1b1b1b;
		case("WeakTearSteel"):return 0x808080;
		case("WeakBlueSteel"):return 0x1111ff;
		case("WeakRedSteel"):return 0xff0000;
		case("WeakStellite"):return 0x736d82;
		case("WeakEnderium"):return 0x0E5B5B;
		case("WeakVibranium"):return 0x6cc978;
		case("Alumina"):return 0xeeeeee;
		default:return -1;
		}
	}
}
