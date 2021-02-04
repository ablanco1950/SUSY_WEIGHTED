import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
 
public class AssignClassWithSusyWeighted {
 
	 public static void main(String args[]) {
		    String fichero = args[0];
		    long Inicio=System.nanoTime();
		    Double Conta=0.0;
		    Double ContLe =0.0;
		    Double Cont0=0.0;
		    Double Cont1=0.0;
		    Double Cont2=0.0;
		    Double Cont3=0.0;
		    Double Cont4=0.0;
		    Double [] Max =new Double[9];
		    Double [] Min =new Double[9];
		    
		    Max[1]= 20.553449630737305;
		    Max[2]= 2.10160493850708;
		    Max[3]= 1.7348390817642212;
		    Max[4]= 33.035621643066406;
		    Max[5]= 2.059720754623413;
		    Max[6]= 1.734686255455017;
		    Max[7]= 21.068876266479492;
		    Max[8]= 1.7406890392303467;
		    Min[1]= 0.25488153100013733;
		    Min[2]= -2.1029269695281982;
		    Min[3]= -1.7347885370254517;
		    Min[4]= 0.4285859763622284;
		    Min[5]= -2.0593061447143555;
		    Min[6]= -1.7342021465301514;
		    Min[7]= 2.598710998427123E-4;
		    Min[8]= -1.7271170616149902;
		       
		    int NumCampos =9;
		    int TopeMemoria = 400002;
		    
		    Double [][] Tabvotos0 = new Double[NumCampos][TopeMemoria];
		    Double [][] Tabvotos1 = new Double[NumCampos][TopeMemoria];
		   
		    for (int i=0; i<NumCampos;i++)
		    {
		    	for (int j=0;j<TopeMemoria;j++)
		    	{
		    		Tabvotos0[i][j]=0.0;
		    		Tabvotos1[i][j]=0.0;
		    	}
		    }
			Double Maximo=0.0;
			System.out.println("Start AssignClassWithSusyWeighted.java");
		    try {
		      FileReader fr = new FileReader(fichero);
		      BufferedReader br = new BufferedReader(fr);
		 
		      String linea;
		      // Case of considering the last 500,000 of Susy records as test
		   //     while( ((linea = br.readLine()) != null) && (Conta  < 4500000.0))
		   	   	  while ((linea = br.readLine()) != null) 
		      {  
		    	 String lineadelTrain []=linea.split(",");
		    	  Conta++;
		    	
		    	  Double FactorPri =0.0;
		    	  Double FactorPri2= 0.0;
		    	  // The input file is SUSY with an additional field added at position 19 to classify Susy's records
		   	      Integer TipoPri = Integer.parseInt(lineadelTrain[19]);
		   	      
		   	// Priorities are assigned based on the type of record	
		   	  switch (TipoPri)
		   	  {
		   	  case 0:
		   		  FactorPri=1.0;
		   		  Cont0++;
		   		  break;
		   	  case 1:
		   		  FactorPri=2.2;
		   		  Cont1++;
		   		  break;
		    case 2:
		   		  FactorPri=2.7;
		   		  Cont2++;
		   		  break;
		   	  case 3:
		   		  FactorPri=2.0;
		   		 Cont3++;
		   		  break;
		   	case 4:
		   		  FactorPri=2.0;
		   		  Cont4++;
		   		  break;
		   	
		   	  default:
		   		  System.out.println("Rare,  type of priority that is not 0, 1, 2, 3 or 4 is sneaked, bad training file selected");
		   		  
		   		  
		   	  }  
		    		  for(int z=1; z<9; z++)
					{
						
						
				
						Double MaxIndice= TopeMemoria - 2.0;
						int indice =0;
						
							Double ValorTrain =Double.parseDouble(lineadelTrain[z]);
					
								ValorTrain = ValorTrain - Min[z];
								Maximo = Max[z] - Min[z];
								indice = (int) ( ( (TopeMemoria - 2.0) * ValorTrain)/ Maximo);
								
							
							
			
							
								// THE MAXIMUM INDEX 400000, 400001 reserves the number of records
								// and 400002 the overfloweds, if any
					
							if ( (indice > (TopeMemoria-2)) || (indice < 0))
							{
								System.out.println(" index overflowed=" + indice + " in the field="+z );
								indice=TopeMemoria;
							}
						//  Priorities are assigned based on the type of record and field
							FactorPri2=0.0;
							if (TipoPri == 1 )
							{
								if (z==1)
								{FactorPri2 = -0.6;}
								if (z==2)
								{FactorPri2 = 0.0;}
								if (z==3)
								{FactorPri2 = -0.3;}
								if (z==4)
								{FactorPri2 = 0.3;}
								if (z==5)
								{FactorPri2 = -0.3;}
								if (z==6)
								{FactorPri2 = -0.2;}
								if (z==7)
								{FactorPri2 = -0.6;}
								if (z==8)
								{FactorPri2 = 0.4;}
							}
							if (TipoPri == 2 )
							{
								if (z==1)
								{FactorPri2 = -1.0;}
								if (z==2)
								{FactorPri2 = -0.1;}
								if (z==3)
								{FactorPri2 = -0.4;}
								if (z==4)
								{FactorPri2 = 0.6;}
								if (z==5)
								{FactorPri2 = -0.4;}
								if (z==6)
								{FactorPri2 = -0.3;}
								if (z==7)
								{FactorPri2 = -0.7;}
								if (z==8)
								{FactorPri2 = 0.2;}
							}	
							if (TipoPri == 3 )
							{
								if (z==1)
								{FactorPri2 = -0.6;}
								if (z==2)
								{FactorPri2 = -0.2;}
								if (z==3)
								{FactorPri2 = -0.4;}
								if (z==4)
								{FactorPri2 = 0.7;}
								if (z==5)
								{FactorPri2 = -0.4;}
								if (z==6)
								{FactorPri2 = -0.3;}
								if (z==7)
								{FactorPri2 = -0.8;}
								if (z==8)
								{FactorPri2 = 0.1;}
							}	
							if (TipoPri == 4 )
							{
								if (z==1)
								{FactorPri2 = -0.6;}
								if (z==2)
								{FactorPri2 = -0.2;}
								if (z==3)
								{FactorPri2 = -0.4;}
								if (z==4)
								{FactorPri2 = 0.7;}
								if (z==5)
								{FactorPri2 = -0.4;}
								if (z==6)
								{FactorPri2 = -0.3;}
								if (z==7)
								{FactorPri2 = -0.8;}
								if (z==8)
								{FactorPri2 = 0.1;}
							}
						
							Double valor=0.0;
							if (Double.parseDouble(lineadelTrain[0]) == 0.0)
							{
								
								valor= Tabvotos0[z][TopeMemoria-1];
								
								
									valor++;
									Tabvotos0[z][TopeMemoria-1]=valor;
				
									
									valor= Tabvotos0[z][indice];
									
									
									valor=valor+FactorPri;
									Tabvotos0[z][indice]=valor;
									
									
									
									
							
							}
							else
							{
								valor= Tabvotos1[z][TopeMemoria-1];
								
								
								valor++;
								Tabvotos1[z][TopeMemoria-1]=valor;
						
								valor= Tabvotos1[z][indice];
								
								
								valor=valor+FactorPri+FactorPri2;
								Tabvotos1[z][indice]=valor;
								
							
							} // fin if 
						 }// fin for z
						 
		    	   } // fin while
		      fr.close();
		      System.out.println("Readed records "+ fichero + ": " + Conta);
		    } // fin try
		    catch(Exception e) {
		      System.out.println("Exception reading file "+ fichero + ": " + e);
		    }
		 
  //**************************************************************************************
    
   
   
    Double TotAciertos=0.0;
    Double TotFallos =0.0;
    Double TotValoresACero=0.0;
    Conta=0.0;
    String ficheroTest = args[1];
    try {
        FileReader fr = new FileReader(ficheroTest);
        BufferedReader br = new BufferedReader(fr);
        FileWriter Salida = null;
        PrintWriter pw = null;
        Salida = new FileWriter("FileTextWithClassAsigned.txt");
        pw = new PrintWriter(Salida);
        String linea;
     // Case of considering the last 500,000 records as test
        // while(((linea = br.readLine()) != null) && (Conta  < 4500000.0))
 	      while((linea = br.readLine()) != null) 
{ 
String lineadelTest []=linea.split(",");
Conta++;

Double TotValor0=0.0;
Double TotValor1=0.0;
Double TotValores = 0.0;

for(int z=1; z<9; z++)
{

int indice=0;

Double ValorTrain = Double.parseDouble(lineadelTest[z]);
ValorTrain = ValorTrain - Min[z];
Maximo = Max[z] - Min[z];
indice = (int) ( ( (TopeMemoria - 2) * ValorTrain)/ Maximo);



if ( (indice > ( TopeMemoria - 2) )|| (indice < 0))
{
	System.out.println(" Index overflowdes =" + indice + " in the field="+z );
	indice=TopeMemoria ;
}

Double valor=0.0;
	
    //frequencies are recovered
	Double valor0= Tabvotos0[z][indice];
	

	Double valor1= Tabvotos1[z][indice];
	Double FactorPri = 1.0;
	
	
	
	if (indice < (TopeMemoria -1)) 
	{ 
		
		// In SUSY There are 2712173.0 class 0 and 2287827.0 class 1 registers,
		// to compensate because there are more class 0s
		valor0=valor0* 2287827.0/2712173.0;
		// valor0=valor0* 2058398.0/2441602.0;

		TotValor0=TotValor0+ (valor0/(valor0 + valor1))*FactorPri;
		  TotValor1=TotValor1+(valor1/(valor0 + valor1))*FactorPri;
		
	
	TotValores = TotValores + valor1 - valor0;
	}		
} // fin for int z=1 

if (TotValores == 0.0) { 

TotValoresACero++;}
else {
if (TotValor1 > TotValor0)
{
if ( Double.parseDouble(lineadelTest[0] )== 0.0)
{

   TotFallos++;
}else {

	  TotAciertos++;
}
}
else
{
if (Double.parseDouble(lineadelTest[0] ) == 0.0)
{

	  TotAciertos++;
}else {

	  TotFallos++;
	    }
}
} // fin de else  if (TotValores == 0.0)
if (TotValor1 > TotValor0)
  	 lineadelTest[0]="1.000000000000000000e+00";
   else
  	 lineadelTest[0]="0.000000000000000000e+00";
  	 
  linea=String.join(",", lineadelTest);
  pw.println(linea);
} // fin while 
 	     System.out.println("---------------------------------------------------------------------------");
 	   System.out.println("The two messages that follow should only be considered in the case of testing");
 	   System.out.println("with a test file that already has the classes assigned");
 	   System.out.println("In order to establish the discrepancies with the method used here to assign the classes");
 	   System.out.println(" Total matches with the class that had the test file = " + TotAciertos);
       System.out.println(" Total discrepancies with the class that had the test file = " + TotFallos);
       System.out.println("---------------------------------------------------------------------------");
    System.out.println(" Assigned without foundation = " + TotValoresACero); 	  
        
        fr.close();
        pw.close();
        Salida.close();
        System.out.println("Records readed test file "+ ficheroTest  + ": " + Conta);
        Double FinalParcial =(System.nanoTime()-Inicio)/1000000000.0;
        System.out.println("Total run time= " + FinalParcial );
      }
      catch(Exception e) {
        System.out.println("Exception reading file "+ fichero + ": " + e);
      }
//________________________________________________________________________________________
  }// fin del main
}