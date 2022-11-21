import { ServicePessoaService } from './../../service/service-pessoa.service';
import { ModelPessoa } from './../../model/model-pessoa';
import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs'

@Component({
  selector: 'app-listar-pessoa',
  templateUrl: './listar-pessoa.component.html',
  styleUrls: ['./listar-pessoa.component.css']
})
export class ListarPessoaComponent implements OnInit {

  pessoas: Observable <ModelPessoa[]>;
  displayedColumns = ['nome', 'idade', 'profissao']
  
  constructor(private servicePessoaService: ServicePessoaService) {
      this.pessoas = servicePessoaService.listarPessoa();
   }

  ngOnInit(): void {
  }

}
