#!/usr/bin/env python
# -*- coding: utf-8 -*-

###
#   catalogo.py
#
#   Definição e implementação da
#   classe Catalogo e suas funções
###

from livro import *

class Catalogo:
    def __init__(self):
        self.__livros = list()

    # Função que efetivamente realiza a leitura de um
    # livro. Retorna uma tupla contendo o livro e a
    # última linha lida, que no caso será ou '\n' ou
    # '', indicando se a leitura deve continuar ou se
    # o arquivo arquivo acabou, respectivamente.
    def __lerLivro(self, f):
        codigo = f.readline()

        # Evita erros de leitura caso existam linhas
        # em branco extras
        if codigo == '\n' or codigo == '':
            return (None, codigo)

        codigo = codigo.rstrip("\n")
        titulo = f.readline().rstrip("\n")
        autor = f.readline().rstrip("\n")
        assunto = f.readline().rstrip("\n")
        dataStr = f.readline().rstrip("\n")
        dataPub = date(int(dataStr[6:10]), int(dataStr[3:5]), int(dataStr[0:2]))
        editora = f.readline().rstrip("\n")
        resumoPart = f.readline()
        resumo = ''
        # Lendo o resumo até achar uma linha em branco
        # ou o final do arquivo
        while resumoPart != '\n' and resumoPart != '':
            resumo += resumoPart
            resumoPart = f.readline()

        resumo = resumo.rstrip("\n")

        livro = Livro(codigo, titulo, autor, assunto, dataPub, editora, resumo)
        return (livro, resumoPart)

    # Função que verifica se o livro já existe no catálogo
    def __possuiLivro(self, livro):
        for l in self.__livros:
            if livro.getCodigo() == l.getCodigo():
                return True

        return False

    # Função para adicionar um livro do Catálago
    def adicionaLivro(self, livro):
        if not self.__possuiLivro(livro):
            self.__livros.append(livro)

    # Função para remover um livro do Catálago
    def removeLivro(self, codigo):
        pos = 0
        for livro in self.__livros:
            if livro.getCodigo() == codigo:
                self.__livros.pop(pos)
                break
            pos += 1

    # Função que abre um arquivo para leitura dos livros
    def lerCatalogo(self, arquivo):
        arqv = open(arquivo, 'r')
        posArqv = None
        while posArqv != '':
            (livro, posArqv) = self.__lerLivro(arqv)
            if livro != None:
                self.adicionaLivro(livro)

    # Função atualizar o Catálago com base no arquivo
    def atualiza(self, arquivo):
        f = open(arquivo, 'r')
        line = f.readline()

        while line != '':
            line = line.rstrip('\n')

            # Caso de inserção
            if line == 'i':
                (livro, posArqv) = self.__lerLivro(f)
                self.adicionaLivro(livro)

            # Caso de alteração
            elif line == 'a':
                (livro, posArqv) = self.__lerLivro(f)
                if self.__possuiLivro(livro):
                    self.removeLivro(livro.getCodigo())
                    self.adicionaLivro(livro)

            # Caso de exclusão
            elif line == 'e':
                codigo = f.readline().rstrip("\n")
                self.removeLivro(codigo)

            line = f.readline()

    # Função para escrita do arquivo de saída
    def escreveSaida(self, arquivo):
        f = open(arquivo, 'w')

        self.ordena(Livro.comparaCodigo)
        f.write("Lista de Livros Ordenada Crescentemente por Codigo:\n")
        for livro in self.__livros:
            f.write('\n')
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')

        f.write('\n')
        self.ordena(Livro.comparaTitulo)
        f.write("Lista de Livros Ordenada Decrescentemente por Titulo:\n")
        for livro in self.__livros:
            f.write('\n')
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')

        f.write('\n')
        self.ordena(Livro.comparaAutor)
        f.write("Lista de Livros Ordenada Crescentemente por Autor:\n")
        for livro in self.__livros:
            f.write('\n')
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')

        f.write('\n')
        self.ordena(Livro.comparaData)
        f.write("Lista de Livros Ordenada Decrescentemente por Data de Publicacao:\n")
        for livro in self.__livros:
            f.write('\n')
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')

    # Função para reescrita do Catálago
    def escreveCatalogo(self, arquivo):
        f = open(arquivo, 'w')

        if len(self.__livros) == 0:
            return;

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
                if comparador(self.__livros[j], self.__livros[minPos]) < 0:
                    minPos = j

            # Swap livros
            self.__livros[i], self.__livros[minPos] = self.__livros[minPos], self.__livros[i]
