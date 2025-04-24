import { SistemaRHA, FuncionarioA, DepartamentoA } from "./SistemaRHA";
import { HRSystemB, EmployeeB } from "./SistemaRHB";

export class AdaptadorBtoA {
  constructor(
    private sistemaA: SistemaRHA,
    private sistemaB: HRSystemB
  ) {}

  private converterEmployeeParaFuncionario(employee: EmployeeB): FuncionarioA {
    const departamentoMap: Record<string, DepartamentoA> = {
      "Information Technology": DepartamentoA.TI,
      "Human Resources": DepartamentoA.RH,
      "Finance": DepartamentoA.FINANCEIRO,
      "Marketing": DepartamentoA.MARKETING,
      "Operations": DepartamentoA.OPERACOES,
    };

    return {
      id: parseInt(employee.employeeId.replace("EMP-", "")),
      nome: employee.personalInfo.firstName,
      sobrenome: employee.personalInfo.lastName,
      dataContratacao: new Date(employee.employmentDetails.startDate),
      cargo: employee.employmentDetails.position,
      departamento: departamentoMap[employee.employmentDetails.division] ?? DepartamentoA.OPERACOES,
      salario: employee.employmentDetails.compensation.baseSalary,
      statusAtivo: employee.status === "ACTIVE",
    };
  }

  importarFuncionarios(): void {
    const employees = this.sistemaB.getAllEmployees();
    for (const emp of employees) {
      const funcionario = this.converterEmployeeParaFuncionario(emp);
      this.sistemaA.adicionarFuncionario(funcionario);
    }
  }
}
