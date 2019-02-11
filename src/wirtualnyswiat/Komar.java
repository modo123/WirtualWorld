package wirtualnyswiat;

import java.util.Random;

public class Komar extends Zwierze
{
    
    public Komar(int x, int y)
    {
            wiek = 0;
            id = 11;
            sila = 1;
            inicjatywa = 1;
            pozX = x;
            pozY = y;
            znak = 'K';
            nazwa = "Komar";
            zyje = true;
            rozmnozony = false;
    }

    public Komar(Komar komar)
    {
            wiek = 0;
            id = komar.id;
            sila = 1;
            inicjatywa = 1;
            pozX = komar.pozX;
            pozY = komar.pozY;
            znak = komar.znak;
            nazwa = komar.nazwa;
            zyje = true;
            rozmnozony = false;
    }


    @Override
    public Organizm rozmnoz()
    {
            return new Komar(this);
    }

    @Override
    public String kolizja(Organizm organizm)
    {
        Random rand = new Random();
            if (organizm.getId() == id)
                    if ( wiek > 5 && organizm.getWiek() > 5 && !rozmnozony )
                    {
                            rozmnozony = true;
                            return "rozmnoz";
                    }
                    else return "nieRobNic";
            else if (organizm.getSila() < sila ) 
                    return "zabij";
            else if (organizm.getSila() > sila )
            {
                    int szansa = rand.nextInt(101);
                    if (szansa < 50) 
                            return "przezyjAtak";
                    else return "zgin";
            }
            else if (organizm.getSila() == sila)
                    return "zabij";
            else return "nieRobNic";
    }

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
            zwiekszWiek();
            return ruch;
    }
    }
