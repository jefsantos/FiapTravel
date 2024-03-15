# FiapTravel

### Cadastro de usuario
`http://localhost:9090/auth/register`

##### Body do cadastro:

{
    "login":"NOME USUARIO",
    "role": "ADMIN",
    "password":"102040"
}



### Logar depois do usuario criado

`http://localhost:9090/auth/login`
#####Body do login obs: pegar o token gerado
{
    "login":"jeferson",
    "password":"102040"
}


###Cadastrar empreendmentos

`http://localhost:9090/empreendimentos`


#####Body cadastro empreendimento, nao esquecer de passar o token
{
  "nomeEmpreendimento": "Hotel Fazenda Santa Rita 1",
  "user": {
    "id": "4c85353c-6a66-44d1-9f1f-360ce9a71e1e"
  }
}
