package wirtualnyswiat;

import java.util.Random;

public abstract class Zwierze extends Organizm 
{
    
            @Override
    	public int akcja(int wielkoscSwiata)
        {
            Random rand = new Random();
            
            int wielkosc = wielkoscSwiata - 1;
	
	int ruch = rand.nextInt(8) + 1;


	boolean wykonacRuch = true;
	while (wykonacRuch) 
	{
		switch (ruch)
		{
		case 1:
			if (pozX > 0 && pozY > 0)
                        { 
				pozX--; 
                                pozY--; 
                                wykonacRuch = false; 
                                break;
                        }
		case 2:
			if (pozY > 0)
                        {
				pozY--; ruch = 2; wykonacRuch = false;  break;
                        }
		case 3:
			if (pozX < wielkosc  && pozY > 0)
                        {
				pozX++; pozY--; ruch = 3; wykonacRuch = false; break;
                        }
		case 4:
			if (pozX < wielkosc )
                        {
				pozX++; ruch = 4; wykonacRuch = false; break;
                        }
		case 5:
			if (pozX < wielkosc  && pozY < wielkosc )
                        {
				pozX++; pozY++; ruch = 5; wykonacRuch = false; break;
                        }
		case 6:
			if (pozY < wielkosc )
                        {
				pozY++; ruch = 6; wykonacRuch = false; break;
                        }
		case 7:
			if (pozX > 0 && pozY < wielkosc )
                        {
				pozX--; pozY++; ruch = 7; wykonacRuch = false; break;
                        }
		case 8:
			if (pozX > 0)
                        {
				pozX--; ruch = 8; wykonacRuch = false; break;
                        }
		}
		if (wykonacRuch)
			ruch = rand.nextInt(8) + 1;
	}
	zwiekszWiek(); 
	return ruch;
        }
    
        
            @Override
        public String kolizja(Organizm organizm)
        {
            Random rand = new Random();
                if (organizm.getId() == id) 
                        if ( wiek > 5 && organizm.getWiek() > 5 && !rozmnozony ) 
                        {															//oba wiek>5 i 1 zwierze tylko raz moze rozmnozyc
                                rozmnozony = true;
                                return "rozmnoz";
                        }
                        else return "nicRobNic";
                else if (organizm.getId() == 4 && organizm.getSila() < sila) 
                        return "zabijIZatruty";
                else if (organizm.getId() == 11 && organizm.getSila() < sila)
                {
                        int szansa = rand.nextInt(100);
                        if (szansa < 50) 
                                return "przezyjObrone";
                        else return "zabij";
                }
                else if (organizm.getSila() < sila ) 
                        return "zabij";
                else if (organizm.getSila() > sila )
                        return "zgin";
                else if (organizm.getSila() == sila) 
                        return "zabij";
                else return "nieRobNic";
        }
	
            @Override
        public abstract Organizm rozmnoz();
	
            @Override
        public void cofnijRuch(int ruch)
        {
	switch (ruch)
	{
            case 1:
                            pozX++; pozY++; break;
            case 2:
                            pozY++; break;
            case 3:
                            pozX--; pozY++; break;
            case 4:
                            pozX--; break;
            case 5:
                            pozX--; pozY--; break;
            case 6:
                            pozY--; break;
            case 7:
                            pozX++; pozY--; break;
            case 8:
                            pozX++; break;
	}
}
	
}
