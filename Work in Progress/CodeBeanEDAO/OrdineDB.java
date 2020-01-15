package model.dao;

import java.util.List;


import model.bean.Ordine;


public class OrdineDB {

	public void addFattura(ArrayList<ProdottoCarrello> array,String user)
	{
		
		try{
			
			String id,nome;
			double prezzoSI,importo,prezzoFinale=0,ivaCal,importo2,calcolVarie;
			int quantita,nOrdine=getNumeroOrdine();
			int iva=getIva();
			boolean calcFinal=true;
			
			 
			 
			ivaCal=(double) iva/100;
			
			
			
			if(nOrdine==-1)
				nOrdine=0;
			
			
			for(int i=0;i<array.size();i++)
			{
				id=array.get(i).getId();
				nome=array.get(i).getNome();
				prezzoSI=array.get(i).getPrezzo();
				quantita=array.get(i).getQuantitàSelezionata();
				
			
				
			   importo=prezzoSI*quantita;	
			
			
			if(calcFinal)
			{
				for(int j=0;j<array.size();j++)
				{
					importo2=array.get(j).getQuantitàSelezionata()*array.get(j).getPrezzo();
					calcolVarie=importo2*ivaCal;
					prezzoFinale+=importo2+calcolVarie;
					
				}
				calcFinal=false;
			}
			
			Connection conn = DB.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ordini (N_ordine,id_prodotto,username,IVA,Quantita,Nome,Prezzo,Importo,Prezzo_finale) VALUES("+nOrdine+","+id+",\'"+user+"\',"+iva+","+quantita+",\'"+nome+"\',"+prezzoSI+","+importo+","+prezzoFinale+");");
			ps.executeUpdate();
			
			
			}
			
			} catch (SQLException e) {
				System.out.println("Errore durante la connessione." + e.getMessage());
			}
		
	}
	
	
	public int getNumeroOrdine()
	{
		
		try{
			Connection conn = DB.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(N_ordine) AS N_Order FROM ordini");
	
			ResultSet result=ps.executeQuery();
			result.next();
			
			return result.getInt("N_Order")+1;
			
			
			
			} catch (SQLException e) {
				System.out.println("Errore durante la connessione." + e.getMessage());
			}
		
			return -1;
	}
	
	public ArrayList getLastOrder(){
		
		try{
			Connection conn = DB.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(N_ordine) AS N_Order FROM ordini");
	
			ResultSet result=ps.executeQuery();
			result.next();
			int n_ordine=0;
			n_ordine=result.getInt("N_Order");
			
			System.out.println(n_ordine);
			
			ps = conn.prepareStatement("SELECT Nome,Quantita,Prezzo,Importo,Prezzo_finale,IVA FROM ordini WHERE N_ordine="+n_ordine);
		
			ArrayList arrayx=new ArrayList();
			ResultSet result2=ps.executeQuery();
			
					while(result2.next())
				{
					arrayx.add(result2.getString("Nome"));
					arrayx.add(result2.getInt("Quantita"));
					arrayx.add(result2.getDouble("Prezzo"));
					arrayx.add(result2.getDouble("Importo"));
					arrayx.add(result2.getInt("IVA"));
					arrayx.add(result2.getDouble("Prezzo_finale"));
				
				}
			
			return arrayx;
			
			} catch (SQLException e) {
				System.out.println("Errore durante la connessione. 1 " + e.getMessage());
			}
		
			return null;
		
	}
	
}
