package wirtualnyswiat;

import java.util.Random;

public class Ciern extends Roslina
{
    
    public Ciern(int x, int y)
    {
            wiek = 0;
            id = 26;
            sila = 2;
            inicjatywa = 0;
            pozX = x;
            pozY = y;
            znak = 'C';
            nazwa = "Ciern";
            zyje = true;
            rozmnozony = false;
    }

    public Ciern(Ciern ciern)
    {
            wiek = 0;
            id = ciern.id;
            sila = ciern.sila;
            inicjatywa = ciern.inicjatywa;
            pozX = ciern.pozX;
            pozY = ciern.pozY;
            znak = ciern.znak;
            nazwa = ciern.nazwa;
            zyje = true;
            rozmnozony = false;
    }


    @Override
    public int akcja(int wielkoscSwiata)
    {
        Random rand = new Random();
            if (wiek > 4 && !rozmnozony) 
            {
                    rozmnozony = true;
                    return 1;
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
    public Organizm rozmnoz()
    {
            return new Ciern(this);
    }

}
