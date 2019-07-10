/* 
 * File:   main.c
 * Author: Taffrel Xavier <taffarel_deus@hotmail.com>
 *
 * Created on 25 de Abril de 2019, 19:21
 */

#include <stdio.h>
#include <stdlib.h>

/**
 * Criada a função para somar
 * @return 
 */
int soma() {
    return 0;
}

/**
 * Criada a função para subtrair
 * @return 
 */
int subracao() {
        return 0;
}

/**
 * Criada a função de multiplicar
 * @return 
 */
int multiplicacao() {
        return 0;
}

/**
 * Criada a função de dividir
 * @return 
 */
int divisao() {
        return 0;
}

/*
 * 
 */
int main(int argc, char** argv) {


    int opcao = 0;

    printf("+------Calculadora------+\n");

    printf("Digite:\n");

    printf("1 - Somar\n2 - Subtrair\n3 - Multiplicar\n4 - Dividir\n");

    scanf("%d", &opcao);

    float soma = 0;

    switch (opcao) {
        case 1:

            // while (1) {
            scanf("%2.f", &soma);
            //}
            printf("%2.f", soma);
            break;
        case 2:

            break;
        case 3:

            break;
        case 4:

            break;
    }

    return (0);
}

