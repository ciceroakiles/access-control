# Sistema simplificado de controle de acesso

No escopo deste projeto, considerou-se necessário registrar os horários de entrada e de saída dos funcionários de uma determinada empresa. Como regra de negócio implícita, nenhum deles entra em um dia e sai em outro.

Dessa forma, um objeto do tipo "jornada", o qual representa uma jornada de trabalho diária, possui:
* Id próprio;
* Data do dia trabalhado;
* Hora de saída;
* Hora de entrada;
* Id do funcionário.

No contexto da API, basta enviar uma requisição do tipo POST contendo apenas o id do funcionário uma vez para gerar e registrar a hora de entrada, e uma segunda vez para que o mesmo seja feito com a hora de saída.

O que foi utilizado:
* Spring Boot com Gradle e JPA;
* Banco de dados H2;
* Lombok + MapStruct.

https://digitalinnovation.one/bootcamps/santander-fullstack-developer