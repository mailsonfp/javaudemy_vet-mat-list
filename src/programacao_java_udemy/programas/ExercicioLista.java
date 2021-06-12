package programacao_java_udemy.programas;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import programacao_java_udemy.entidades.Funcionario;

public class ExercicioLista {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite quantos funcionários serão registrados:");
		int n = sc.nextInt();
		
		List<Funcionario> funcionarios = new ArrayList<>();
		for(int i=0; i < n; i++) {
			Integer id = sc.nextInt();
			String nome = sc.next();
			double salario = sc.nextDouble();
			
			funcionarios.add(new Funcionario(id,nome,salario));
		}
		
		imprimeLista(funcionarios);
		
		System.out.println("Digite o ID do funcionário que irá receber aumento:");
		int idFun = sc.nextInt();
		
		Funcionario funcionarioAumento = funcionarios.stream()
				.filter(fun -> fun.getId().equals(idFun))
				.findFirst()
				.orElse(null);
		if(funcionarioAumento == null) {
			System.out.println("Funcionário não encontrado");
		}else {
			System.out.println("Digite o % de aumento:");
			double percentual = sc.nextDouble();
			
			funcionarioAumento.aumentaSalario(percentual);
		}
		
		imprimeLista(funcionarios);
		
		sc.close();
	}
	
	private static void imprimeLista(List<Funcionario> lista) {
		
		System.out.println("\n----------------");
		for(Funcionario fun : lista) {
			System.out.println(fun);
		}
		System.out.println("\n----------------\n");
	}
}
