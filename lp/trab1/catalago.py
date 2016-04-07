#!/usr/bin/env python
# -*- coding: utf-8 -*-

###
#   Trabalho 1 de LP - Python
#   André Barreto Silveira
###

from livro import *

class Catalago:
    def __init__(self):
        self.__livros = list()

    # Função para adicionar um livro do Catálago
    def adicionaLivro(self, livro):
        self.__livros.append(livro)

    # Função para remover um livro do Catálago
    def removeLivro(self, codigo):
        pos = 0
        for livro in self.__livros:
            if livro.getCodigo() == codigo:
                self.__livros.pop(pos)
                break
            pos += 1

    #def __lerLivro(self, f):


    # Função que lê um arquivo e carrega o Catálago
    def lerCatalago(self, arquivo):
        f = open(arquivo, 'r')
        resumoPart = ' '

        while resumoPart != '':
            codigo = f.readline().rstrip("\n")
            titulo = f.readline().rstrip("\n")
            autor = f.readline().rstrip("\n")
            assunto = f.readline().rstrip("\n")
            dataStr = f.readline().rstrip("\n")
            dataPub = date(int(dataStr[6:10]), int(dataStr[3:5]), int(dataStr[0:2]))
            editora = f.readline().rstrip("\n")
            resumoPart = f.readline()
            resumo = ''
            while resumoPart != '\n' and resumoPart != '':
                resumo += resumoPart
                resumoPart = f.readline()

            resumo = resumo.rstrip("\n")

            livro = Livro(codigo, titulo, autor, assunto, dataPub, editora, resumo)
            self.adicionaLivro(livro)

    # Função atualizar o Catálago com base no arquivo
    def atualiza(self, arquivo):
        f = open(arquivo, 'r')
        line = f.readline()

        while line != '':
            # Leitura de dados em caso de inserção ou alteração
            if line == 'i\n' or line == 'a\n':
                codigo = f.readline().rstrip("\n")
                titulo = f.readline().rstrip("\n")
                autor = f.readline().rstrip("\n")
                assunto = f.readline().rstrip("\n")
                dataStr = f.readline().rstrip("\n")
                dataPub = date(int(dataStr[6:10]), int(dataStr[3:5]), int(dataStr[0:2]))
                editora = f.readline().rstrip("\n")
                resumoPart = f.readline()
                resumo = ''
                while resumoPart != '\n' and resumoPart != '':
                    resumo += resumoPart
                    resumoPart = f.readline()

                resumo = resumo.rstrip("\n")

                # Caso de inserção
                if line == 'i\n':
                    livro = Livro(codigo, titulo, autor, assunto, dataPub, editora, resumo)
                    self.adicionaLivro(livro)

                # Caso de alteração
                else:
                    for livro in self.__livros:
                        if livro.getCodigo() == codigo:
                            livro.alteraDados(codigo, titulo, autor, assunto, dataPub, editora, resumo)
                            break

            # Caso de exclusão
            elif line == 'e\n':
                codigo = f.readline().rstrip("\n")
                self.removeLivro(codigo)

            line = f.readline()

    # Função para escrita do arquivo de saída
    def escreveSaida(self, arquivo):
        f = open(arquivo, 'w')

        self.ordena(Livro.comparaCodigo)
        f.write("## Listagem ordenada crescentemente por Código ##\n")
        for livro in self.__livros:
            f.write('\n')
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')

        f.write('\n')
        self.ordena(Livro.comparaTitulo)
        f.write("## Listagem ordenada decrescentemente por Titulo ##\n")
        for livro in self.__livros:
            f.write('\n')
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')

        f.write('\n')
        self.ordena(Livro.comparaAutor)
        f.write("## Listagem ordenada crescentemente por Autor ##\n")
        for livro in self.__livros:
            f.write('\n')
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')

        f.write('\n')
        self.ordena(Livro.comparaData)
        f.write("## Listagem ordenada decrescentemente por Data de Publicação ##\n")
        for livro in self.__livros:
            f.write('\n')
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')

    # Função para reescrita do Catálago
    def escreveCatalago(self, arquivo):
        f = open(arquivo, 'w')
        self.ordena(Livro.comparaCodigo)

        # Primeiro livro
        dados = self.__livros[0].getDados()
        for i in dados:
            f.write(i+'\n')

        # Demais livros
        for livro in self.__livros[1:]:
            f.write('\n')
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')

    # Função de Ordenação (Selection Sort)
    def ordena(self, comparador):
        N = len(self.__livros)
        for i in range(0, N):
            minPos = i
            for j in range(i, N):
                if comparador(self.__livros[j], self.__livros[minPos]) == -1:
                    minPos = j

            # Swap livros
            self.__livros[i], self.__livros[minPos] = self.__livros[minPos], self.__livros[i]
