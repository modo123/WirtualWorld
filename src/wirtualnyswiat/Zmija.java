package wirtualnyswiat;

public class Zmija extends Zwierze
{
    public Zmija(int x, int y)
    {
            wiek = 0;
            id = 4;
            sila = 2;
            inicjatywa = 3;
            pozX = x;
            pozY = y;
            znak = 'Z';
            nazwa = "Zmija";
            zyje = true;
            rozmnozony = false;
    }

    public Zmija(Zmija zmija)
    {
            wiek = 0;
            id = zmija.id;
            sila = zmija.sila;
            inicjatywa = zmija.inicjatywa;
            pozX = zmija.pozX;
            pozY = zmija.pozY;
            znak = zmija.znak;
            nazwa = zmija.nazwa;
            zyje = true;
            rozmnozony = false;
    }


    @Override
    public Organizm rozmnoz()
    {
            return new Zmija(this);
    }

    @Override
    public String kolizja(Organizm organizm)
    {
            if (organizm.getId() == id)
                    if ( wiek > 5 && organizm.getWiek() > 5 && !rozmnozony )
                    {
                            rozmnozony = true;
                            return "rozmnoz";
                    }
                    else return "nicRobNic";
            else if (organizm.getSila() < sila ) 
                    return "zabij";
            else if (organizm.getSila() > sila )
                    return "zginIZatruj";
            else if (organizm.getSila() == sila)
                    return "zabij";
            else return "nieRobNic";
    }
}
