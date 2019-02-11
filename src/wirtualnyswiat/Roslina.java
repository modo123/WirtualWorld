package wirtualnyswiat;

import java.util.Random;

public abstract class Roslina extends Organizm
{
    
        @Override
        public int akcja(int wielkoscSwiata)
        {
	
        Random rand = new Random();
        
        if (wiek > 4 && !rozmnozony)
	{
		int szansa = rand.nextInt(100);
    		if (szansa < 5) 
		{
			rozmnozony = true;
			return 1;
		}
		else return 0;
	}
	else if ( wiek == 0 ) 
	{
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
				pozX--; pozY--; wykonacRuch = false; break;
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

	}
	zwiekszWiek();
	return 0;
        }  
        
       
        @Override
        public String kolizja(Organizm organizm)
        {
            if (organizm.getSila() < sila ) 
                    return "zniszcz";
            else if (organizm.getSila() > sila )
                    return "zniszczony";
            else if (organizm.getId() == id )
                    return "toSamo";
            else return "nieRobNic";
        }
    
     
        @Override
    public void cofnijRuch(int ruch) 
    {
    }
    
        @Override
    public abstract Organizm rozmnoz();
    
}
