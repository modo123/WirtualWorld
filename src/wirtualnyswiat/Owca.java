package wirtualnyswiat;

public class Owca extends Zwierze
{
    public Owca(int x, int y)
    {
            wiek = 0;
            id = 2;
            sila = 4;
            inicjatywa = 4;
            pozX = x;
            pozY = y;
            znak = 'O';
            nazwa = "Owca";
            zyje = true;
            rozmnozony = false;
    }
    
    public Owca(Owca owca)
    {
            wiek = 0;
            id = owca.id;
            sila = owca.sila;
            inicjatywa = owca.inicjatywa;
            pozX = owca.pozX;
            pozY = owca.pozY;
            znak = owca.znak;
            nazwa = owca.nazwa;
            zyje = true;
            rozmnozony = false;

    }
    @Override
    public Organizm rozmnoz()
    {
            return new Owca(this);
    }
}
