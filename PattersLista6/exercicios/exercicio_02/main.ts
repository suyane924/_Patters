import { DepartamentoA, FuncionarioA, SistemaRHA } from "./SistemaRHA";
import { HRSystemB } from "./SistemaRHB";
import { AdaptadorBtoA } from "./AdaptadorBtoA";

console.log("=== DEMONSTRAÇÃO DO ADAPTADOR DE SISTEMAS DE RH ===");

// Instancia os sistemas
const sistemaA = new SistemaRHA();
const sistemaB = new HRSystemB();
const adaptador = new AdaptadorBtoA(sistemaA, sistemaB);

console.log("1. Listando funcionários originais do Sistema A:");
console.log(sistemaA.listarFuncionarios());

console.log("2. Importando funcionários do Sistema B para o Sistema A...");
adaptador.importarFuncionarios();

console.log("3. Funcionários no Sistema A após a importação:");
console.log(sistemaA.listarFuncionarios());

console.log("4. Adicionando novo funcionário manualmente ao Sistema A:");
const novoFuncionario: FuncionarioA = {
  id: 100,
  nome: "Ana",
  sobrenome: "Ferreira",
  dataContratacao: new Date("2023-01-10"),
  cargo: "Analista de Marketing",
  departamento: DepartamentoA.MARKETING,
  salario: 6500,
  statusAtivo: true,
};
sistemaA.adicionarFuncionario(novoFuncionario);
