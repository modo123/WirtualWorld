package wirtualnyswiat;

public class Trawa extends Roslina
{
    public Trawa(int x, int y)
    {
            wiek = 0;
            id = 21;
            sila = 0;
            inicjatywa = 0;
            pozX = x;
            pozY = y;
            znak = 'T';
            nazwa = "Trawa";
            zyje = true;
            rozmnozony = false;
    }

    public Trawa(Trawa trawa)
    {
            wiek = 0;
            id = trawa.id;
            sila = trawa.sila;
            inicjatywa = trawa.inicjatywa;
            pozX = trawa.pozX;
            pozY = trawa.pozY;
            znak = trawa.znak;
            nazwa = trawa.nazwa;
            zyje = true;
            rozmnozony = false;
    }

    @Override
    public Organizm rozmnoz()
    {
            return new Trawa(this);
    }


}
