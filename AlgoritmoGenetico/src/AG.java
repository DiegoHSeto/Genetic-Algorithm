
public class AG {
	
	public static final int TAM_POPULACAO = 100;
	public static final int GERACOES = 1000;
	public static final int NUM_CRUZAMENTOS = 20;
	public static final double PROB_CRUZAMENTO = 0.7;
	public static final double PROB_MUTACAO = 0.1;
	
	public static final String GENES = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALVO = "Rafael Teixeira";
	
	
	
	public static void main(String [] args)
	{
		
		Individuo[] populacao = new Individuo[TAM_POPULACAO];
		
		iniciaPopulacao(populacao);
		
		
		
		System.out.println("------------------------");
		
		for(int i = 0; i < GERACOES; i++)
		{
			for(int j = 0; j < NUM_CRUZAMENTOS; j++)
			{
				int probabilidade = (int) Math.random();
				
				if(probabilidade < PROB_CRUZAMENTO)
				{
					int p1 = (int)(Math.random() * TAM_POPULACAO);
					int p2 = (int)(Math.random() * TAM_POPULACAO);
					int pontuacaoP, pontuacaoF;
					
					while(p1==p2)
					{
						p2 = (int)(Math.random() * TAM_POPULACAO);
					}
					
					Individuo f = cruzarIndividuo(p1, p2, populacao);
					
					if(probabilidade < PROB_MUTACAO)
					{
						mutarIndividuo(f);
					}
					
					pontuacaoP = populacao[p1].getPontuacao();
					pontuacaoF = f.getPontuacao();
					
					if(pontuacaoF > pontuacaoP)
					{
						populacao[p1] = f;
					}

				}
				
			}
			
			int indiceMelhor = getMelhorIndividuo(populacao);
			int scoreMelhor = populacao[indiceMelhor].getPontuacao();
			
			
			System.out.println("Geração " + (i+1) + ":");
			
			for(int k = 0; k < ALVO.length(); k++)
			{
				System.out.printf("%c", populacao[indiceMelhor].getGenes()[k]);
			}
			
			System.out.println();
			System.out.println("Pontuação: " + scoreMelhor);
			
			System.out.println();
			System.out.println();
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void iniciaPopulacao(Individuo[] p)
	{
		for(int i = 0; i < TAM_POPULACAO; i++)
		{
			p[i] = new Individuo();
		}
	}
	
	public static void printaPopulacao(Individuo[] p)
	{
		for(int i = 0; i < TAM_POPULACAO; i++)
		{
			for(int j = 0; j < ALVO.length(); j++)
			{
				System.out.printf("%c", p[i].getGenes()[j]);
			}
			
			System.out.println();
		}
	}
	
	public static Individuo cruzarIndividuo(int pai, int pai2, Individuo[] p)
	{
		int ponto = (int)(Math.random() * ALVO.length());
		
		Individuo filho = new Individuo();
		
		for(int i = 0; i < ponto; i++)
		{
			filho.getGenes()[i] = p[pai].getGenes()[i];
		}
		
		for(int i = ponto; i < ALVO.length(); i++)
		{
			filho.getGenes()[i] = p[pai2].getGenes()[i];
		}
		
		return filho;
	}
	
	public static void mutarIndividuo(Individuo p)
	{
		int r1 = (int)(Math.random() * ALVO.length());
		int r2 = (int)(Math.random() * ALVO.length());
		char aux;
		
		aux = p.getGenes()[r1];
		p.getGenes()[r1] = p.getGenes()[r2];
		p.getGenes()[r2] = aux;
	}
	
	public static int getMelhorIndividuo(Individuo[] p)
	{
		int melhorP = p[0].getPontuacao();
		int posicao = 0;
		
		for(int i = 1; i < TAM_POPULACAO; i++)
		{
			if(p[i].getPontuacao() > melhorP)
			{
				melhorP = p[i].getPontuacao();
				posicao = i;
			}
		}
		
		return posicao;
	}
	

}
