package wirtualnyswiat;

import java.util.Random;

public class Koza extends Zwierze
{

    public Koza(int x, int y)
    {
            wiek = 0;
            id = 13;
            sila = 5;
            inicjatywa = 3;
            pozX = x;
            pozY = y;
            znak = 'A';
            nazwa = "Koza";
            zyje = true;
            rozmnozony = false;
    }

    public Koza(Koza koza)
    {
            wiek = 0;
            id = koza.id;
            sila = koza.sila;
            inicjatywa = koza.inicjatywa;
            pozX = koza.pozX;
            pozY = koza.pozY;
            znak = koza.znak;
            nazwa = koza.nazwa;
            zyje = true;
            rozmnozony = false;
    }

    @Override
    public Organizm rozmnoz()
    {
            return new Koza(this);
    }

    @Override
    public int akcja(int wielkoscSwiata)
    {
        Random rand = new Random();
            int wielkosc = wielkoscSwiata - 1;
            int ruch = rand.nextInt(4) + 1;

            boolean wykonacRuch = true;
            while (wykonacRuch)
            {
                    switch (ruch) 
                    {
                    case 1:
                            if (pozY > 0 && (pozX == 0 || pozX == wielkosc))
                            {
                                    pozY--; ruch = 2; wykonacRuch = false;  break;
                            }
                    case 2:
                            if (pozX < wielkosc && (pozY == 0 || pozY == wielkosc))
                            {
                                    pozX++; ruch = 4; wykonacRuch = false; break;
                            }
                    case 3:
                            if (pozY < wielkosc && (pozX == 0 || pozX == wielkosc))
                            {
                                    pozY++; ruch = 6; wykonacRuch = false; break;
                            }
                    case 4:
                            if (pozX > 0 && (pozY == 0 || pozY == wielkosc))
                            {
                                    pozX--; ruch = 8; wykonacRuch = false; break;
                            }
                    }
                    if (wykonacRuch)
                            ruch = rand.nextInt(4) + 1;
            }
            zwiekszWiek();
            return ruch;
    }
}
