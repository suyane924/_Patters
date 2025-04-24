import { DataAdapter } from "./DataAdapter";
import { DataExterna } from "./DataExterna";
import { DataLocal } from "./DataLocal";


// Código cliente que usa DataLocal
const dataLocal = new DataLocal('15/04/2025');
console.log('Data Local:', dataLocal.formataParaExibicao());

// Biblioteca externa que usa formato diferente
const dataExterna = new DataExterna('2025-04-15');

// Usando o adapter para adaptar DataExterna para a interface de DataLocal
const adaptador = new DataAdapter(dataExterna);
console.log('Data Externa (adaptada):', adaptador.formataParaExibicao());