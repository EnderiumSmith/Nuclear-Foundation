package NuclearFoundation.core;

public class MetalColorizer {
	
	public static int getColorForMetal(String metal){
		switch(metal){
		case("Boron"):return 0x0;
		case("Aluminium"):return 0xe3e6e6;
		case("Titanium"):return 0x1a1a1a;
		case("Cromium"):return 0xe0c2c2;
		case("Iron"):return 0xf2f2f2;
		case("Cobalt"):return 0x968ec9;
		case("Nickel"):return 0xbbbb91;
		case("Copper"):return 0xe38537;
		case("Zinc"):return 0xf1f1c1;
		case("Zirconium"):return 0x0;
		case("Silver"):return 0xaadbf8;
		case("Tin"):return 0xb8d0d0;
		case("Wolfram"):return 0x1a1a1a;
		case("Osmium"):return 0x6a9cad;
		case("Platinum"):return 0xffffff;
		case("Gold"):return 0xe8d323;
		case("Lead"):return 0x1f1c44;
		case("Bismuth"):return 0x676685;
		case("Thorium"):return 0x0;
		case("Uranium"):return 0x0;
		case("Mithril"):return 0x0;
		case("Adamantine"):return 0x0;
		default:return -1;
		}
	}
}
