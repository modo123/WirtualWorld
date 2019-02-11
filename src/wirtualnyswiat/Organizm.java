package wirtualnyswiat;

public abstract class Organizm 
{
        public abstract int akcja(int wielkoscSwiata);
	public abstract String kolizja(Organizm organizm);
	public abstract Organizm rozmnoz();
	public abstract void cofnijRuch(int ruch); 
        
        public int getId(){ return id;}
        public int getSila(){ return sila;}
        public int getInicjatywa(){ return inicjatywa;}
        public int getPozX(){ return pozX;}
        public int getPozY(){ return pozY;}
        public int getWiek(){ return wiek;}
        public void zwiekszWiek(){ wiek++;}
        public boolean getZyje(){ return zyje;}
        public void setNiezyje(){ zyje = false;}
        public char getZnak(){ return znak;}
        public  String getNazwa(){ return nazwa;}
        
	
	protected int wiek;
	protected int id;
	protected int sila;
	protected int inicjatywa;
	protected int pozX;
	protected int pozY;
	protected char znak;
	protected String nazwa;
	protected boolean zyje;
	protected boolean rozmnozony;
	
}
