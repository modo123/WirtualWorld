package wirtualnyswiat;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Swiat 
{

    private Vector<Organizm> organizmy;

    private List<String> listaLog;
    private static final int wielkoscSwiata = 20; 
                                                 
	
    
    public Swiat()
    {
            
            organizmy = new Vector<>();
         
            organizmy.addElement(new Wilk(1,1));
            organizmy.addElement(new Wilk(10,19));
            organizmy.addElement(new Owca(4,4));
            organizmy.addElement(new Owca(8,8));
            organizmy.addElement(new Owca(12,12));
            organizmy.addElement(new Zmija(15,15));
            organizmy.addElement(new Komar(17,17));
            organizmy.addElement(new Komar(19,19));
            organizmy.addElement(new Koza(0,3));
            organizmy.addElement(new Trawa(19,8));
            organizmy.addElement(new Trawa(10,14));
            organizmy.addElement(new Mlecz(4,16));
            organizmy.addElement(new Ciern(18,3));
    }

    
    
    public Swiat(List<String> mapa)
    {
        organizmy = new Vector<>();
        
        
        for (int i = 0; i < mapa.size(); i+=3)
        {
            String nazwa = mapa.get(i);
            int pozX = Integer.parseInt(mapa.get(i+1));
            int pozY = Integer.parseInt(mapa.get(i+2));
            
            
            switch (nazwa)
            {
                case "Koza": organizmy.addElement(new Koza(pozX, pozY)); break;
                case "Wilk": organizmy.addElement(new Wilk(pozX, pozY)); break;
                case "Mlecz": organizmy.addElement(new Mlecz(pozX, pozY)); break;        
                case "Trawa": organizmy.addElement(new Trawa(pozX, pozY)); break;        
                case "Ciern": organizmy.addElement(new Ciern(pozX, pozY)); break;
                case "Zmija": organizmy.addElement(new Zmija(pozX, pozY)); break;
                case "Owca": organizmy.addElement(new Owca(pozX, pozY)); break;    
                case "Komar": organizmy.addElement(new Komar(pozX, pozY)); break;    
            }
        }  
    }
	
	public void wykonajTure()
        {
            String dzialanie;
           
            listaLog = new ArrayList<>();
            
            if (!listaLog.isEmpty())
                listaLog.clear();
            

	Vector<Integer> doUsuniecia = new Vector<>();
	Vector<Organizm> doDodania = new Vector<Organizm>();

	int ruch; 

	
	
	sortujOrganizmy();

	
	for (int i = 0; i < organizmy.size(); ++i)
	{
		
		if (organizmy.get(i).getZyje() == false)
			continue;
		ruch = organizmy.get(i).akcja(wielkoscSwiata); 
		for (int j = 0; j < organizmy.size(); ++j) 
		{
			if (organizmy.get(j).getZyje() == false) 
				continue;
			
			if ((j != i) && (organizmy.get(i).getPozX() == organizmy.get(j).getPozX()) &&
				(organizmy.get(i).getPozY() == organizmy.get(j).getPozY()))
			{
				
				dzialanie = organizmy.get(i).kolizja(organizmy.get(j)); 
				
				if (null != dzialanie)
				
                            switch (dzialanie) 
                            {
                                case "zabij":
                                    if (organizmy.get(j).getId() < 20) 
                                        listaLog.add(organizmy.get(i).getNazwa() + " zabija " + organizmy.get(j).getNazwa() + "\n");
                                    else
                                        listaLog.add(organizmy.get(i).getNazwa() + " zjada " + organizmy.get(j).getNazwa() + "\n");
                                    doUsuniecia.addElement(j); 
                                    organizmy.get(j).setNiezyje(); 
                                    break;
                                case "zabijIZatruty":
                              
                                    listaLog.add(organizmy.get(i).getNazwa() + " zabija " + organizmy.get(j).getNazwa() + "\n");
                                    doUsuniecia.addElement(j);
                                    organizmy.get(j).setNiezyje();                     
                                    listaLog.add(organizmy.get(i).getNazwa() + " ginie zatruty od " + organizmy.get(j).getNazwa() + "\n");
                                    doUsuniecia.addElement(i);
                                    organizmy.get(i).setNiezyje();
                                    break;
                                case "przezyjAtak":
                                    listaLog.add( organizmy.get(i).getNazwa() + " przezywa atak " + organizmy.get(j).getNazwa() + "\n");
                                    organizmy.get(i).cofnijRuch(ruch);
                                    break;
                                case "przezyjObrone":
                                   
                                    listaLog.add( organizmy.get(j).getNazwa() + " przezywa atak " + organizmy.get(i).getNazwa() + "\n");
                                    organizmy.get(j).cofnijRuch(ruch);
                                    break;
                                case "zgin":
                                    listaLog.add( organizmy.get(i).getNazwa() + " ginie od " + organizmy.get(j).getNazwa() + "\n");
                                    doUsuniecia.addElement(i);
                                    organizmy.get(i).setNiezyje();
                                    break;
                                case "zginIZatruj":
                                    listaLog.add( organizmy.get(i).getNazwa() + " ginie od " + organizmy.get(j).getNazwa() + "\n");
                                    doUsuniecia.addElement(i);
                                    organizmy.get(i).setNiezyje();
                                    listaLog.add( organizmy.get(j).getNazwa() + " ginie zatruty od " + organizmy.get(i).getNazwa() + "\n");
                                    doUsuniecia.addElement(j);
                                    organizmy.get(j).setNiezyje();
                                    break;
                                case "rozmnoz":
                                    listaLog.add("Powstaje " + organizmy.get(i).getNazwa() + "\n");
                                    organizmy.get(i).cofnijRuch(ruch);
                                    doDodania.addElement(organizmy.get(i).rozmnoz());                                   
                                    break;
                                case "zniszcz":
                                    listaLog.add(organizmy.get(i).getNazwa() + " niszczy " + organizmy.get(j).getNazwa() + "\n");
                                    doUsuniecia.addElement(j);
                                    organizmy.get(j).setNiezyje();
                                    break;
                                case "zniszczony":
                                    listaLog.add(organizmy.get(i).getNazwa() + " zniszczony przez " + organizmy.get(j).getNazwa() + "\n");
                                    doUsuniecia.addElement(i);
                                    organizmy.get(i).setNiezyje();
                                    break;
                                case "toSamo":
                                    listaLog.add(organizmy.get(j).getNazwa() + " wypiera stary " + organizmy.get(i).getNazwa() + "\n");
                                    doUsuniecia.addElement(i);
                                    organizmy.get(i).setNiezyje();
                                    break;
                            }
			}
		}
		
		if ( organizmy.get(i).getId() > 20 && ruch == 1)
			doDodania.addElement(organizmy.get(i).rozmnoz());
	}

	
	if(doUsuniecia.size() > 0 )
		sortujWektor(doUsuniecia);

	
	for (int i = 0; i < doUsuniecia.size(); ++i)
		usunOrganizm(doUsuniecia.get(i)-i); 
											
	for (int i = 0; i < doDodania.size(); ++i)
	{
		dodajOrganizm(doDodania.get(i));
		organizmy.get(organizmy.size()-1).akcja(wielkoscSwiata);																//pierwotnie jego x,y jest to samo co matki
	}

        
        }

	
        private void usunOrganizm(int nr)
        {
                organizmy.removeElementAt(nr);
        }
	
        private void dodajOrganizm(Organizm organizm)
        {
                organizmy.addElement(organizm);
        }


        private void sortujOrganizmy()
        {
            Organizm temp;
            boolean finished = false;
            while (!finished)
                {
               finished = true;
               for (int i = 0; i < organizmy.size()-1; i++) 
                   {
                           if (organizmy.get(i).getInicjatywa() < organizmy.get(i+1).getInicjatywa())
                           {
                            temp = organizmy.get(i);
                            organizmy.setElementAt(organizmy.get(i+1), i);
                            organizmy.setElementAt(temp, i + 1);
                            finished = false;
                           }
                           else if (organizmy.get(i).getInicjatywa() == organizmy.get(i+1).getInicjatywa() &&
                                                organizmy.get(i).getWiek() < organizmy.get(i+1).getWiek())
                            {
                            temp = organizmy.get(i);
                            organizmy.setElementAt(organizmy.get(i+1), i);
                            organizmy.setElementAt(temp, i+1);
                            finished=false;
                             }
                    }
                }
        }
	
        
        private void sortujWektor(Vector<Integer> w)
        {
            int temp;
            boolean finished = false;
            while (!finished)    
            {
               finished = true;
               for (int i = 0; i < w.size()-1; i++) 
               {
                  if (w.get(i) > w.get(i+1)) 
                  {
                     temp = w.get(i);
                     w.setElementAt(w.get(i+1), i);
                     w.setElementAt(temp, i+1);
                     finished=false;
                  }
                }
             }
        }
        
        public Vector<Organizm> getOrganizmy()
        {
            return organizmy;   
        }
        

        public List<String> getListaLog()
        {
            return listaLog;
        }
}

