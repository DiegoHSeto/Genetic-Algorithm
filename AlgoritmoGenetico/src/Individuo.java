
public class Individuo {
	
	private int pontuacao;
	private char [] genes;
	
	public Individuo()
	{
		genes = new char[AG.ALVO.length()];
		
		int gene;
		
		for(int i = 0; i < genes.length; i++)
		{
			gene = (int)(Math.random() * AG.GENES.length());
			
			genes[i] = AG.GENES.charAt(gene);
		}
	}
	
	private int calculaPontuacao()
	{
		int soma = 0;
		
		for(int i = 0; i < genes.length; i++)
		{
			if(genes[i]==AG.ALVO.charAt(i))
			{	
				soma++;
			}
		}
		
		return soma;
	}

	public int getPontuacao() {
		return calculaPontuacao();
	}

	public char[] getGenes() {
		return genes;
	}

	public void setGenes(char[] genes) {
		this.genes = genes;
	}

}
