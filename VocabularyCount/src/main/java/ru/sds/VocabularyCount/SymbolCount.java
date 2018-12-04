package ru.sds.VocabularyCount;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SymbolCount implements ISymbolCount {
	
	//String str = "aaabccbdd";
	//char  ch= str.charAt(0);
	ArrayList <String> list = new ArrayList<String>();
	List <InformSymbol> infoList = new ArrayList<InformSymbol>();
	InformSymbol informSymbol = new InformSymbol();
	
	
	/*public Map<Integer, String> StaticCollection__(String symb) {
		Map<Integer,String> mas = new HashMap<Integer,String>();
		
		list.add("a");//aaabccbdd
		list.add("b");
		list.add("a");
		list.add("b");
		list.add("a");
		list.add("a");
		
		for(int i = 0; i<list.size();i++) {
			if(list.get(i)==symb) {
				informSymbol.setSymbol(symb);
				informSymbol.setCount(informSymbol.getCount()+1);
				
			}
		}
		mas.put(informSymbol.getCount(), informSymbol.getSymbol());
		return mas;
	}*/
	
	public Map<String,Integer> StaticCollection(String str){
		
		Map<String,Integer> mas = new HashMap<String,Integer>();
		
		for (int i = 0; i < str.length(); i++) {
			
			InformSymbol informSymbol = getInfoSymbol(str.charAt(i));
			
			if(informSymbol==null) {
				
				informSymbol = new InformSymbol();
				informSymbol.setSymbol(str.charAt(i));
				informSymbol.setCount(informSymbol.getCount()+1);
				infoList.add(informSymbol);
				
			}else {
				informSymbol.setCount(informSymbol.getCount()+1);
			}
			
		}
		
		for (int i = 0; i < infoList.size(); i++) {
			mas.put(String.valueOf(infoList.get(i).getSymbol()),infoList.get(i).getCount());
		}
		
		return mas;
	}
	
	 protected InformSymbol getInfoSymbol(char ch) {
		 InformSymbol informSymbol=null;
		 
		 for (int i = 0; i < infoList.size(); i++) {
			if(infoList.get(i).getSymbol()==ch) {
				informSymbol=infoList.get(i);
			}
		}
		 return informSymbol;
	 }
	
	public void  print() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void main(String[] args) {
		//InformSymbol informSymbol = new InformSymbol();
		SymbolCount symbolCount = new SymbolCount();
		//symbolCount.StaticCollection();
		symbolCount.print();
		System.out.println(symbolCount.StaticCollection("baaabccdbd+++++="));
	}
	
	
	
}


