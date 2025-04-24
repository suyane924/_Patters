import { DataExterna } from "./DataExterna";

export class DataAdapter {
  private dataExterna: DataExterna;

  constructor(dataExterna: DataExterna) {
    this.dataExterna = dataExterna;
  }

  getDataFormatada(): string {
    const dia = this.dataExterna.getDia();
    const mes = this.dataExterna.getMes();
    const ano = this.dataExterna.getAno();
    return `${dia}/${mes}/${ano}`;
  }

  formataParaExibicao(): string {
    const dia = this.dataExterna.getDia();
    const mes = parseInt(this.dataExterna.getMes());
    const ano = this.dataExterna.getAno();
    return `${dia} de ${this.obterNomeMes(mes)} de ${ano}`;
  }

  private obterNomeMes(mes: number): string {
    const meses = [
      "janeiro",
      "fevereiro",
      "março",
      "abril",
      "maio",
      "junho",
      "julho",
      "agosto",
      "setembro",
      "outubro",
      "novembro",
      "dezembro",
    ];
    return meses[mes - 1];
  }
}
