import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ModelPessoa } from '../model/model-pessoa';

@Injectable({
  providedIn: 'root'
})
export class ServicePessoaService {

  constructor(private httpcliente: HttpClient) {


  }
  private readonly url = 'http://localhost:8080/api/pessoas';
  listarPessoa(){

    return this.httpcliente.get<ModelPessoa[]>(this.url);
  }
}
