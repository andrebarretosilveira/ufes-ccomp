#!/usr/bin/env python
# -*- coding: utf-8 -*-

from livro import *

class Catalago:
    def __init__(self):
        self.__livros = list()

    def adicionaLivro(self, livro):
        self.__livros.append(livro)

    def removeLivro(self, codigo):
        pos = 0
        for livro in self.__livros:
            if livro.getCodigo() == codigo:
                self.__livros.pop(pos)
                break
            pos += 1

    def lerCatalago(self, arquivo):
        f = open(arquivo, 'r')
        info = [0] * 12
        pos = 0
        resumoPart = ' '

        while resumoPart != '':
            codigo = str(f.readline()[:-1])
            titulo = str(f.readline()[:-1])
            autor = str(f.readline()[:-1])
            assunto = str(f.readline()[:-1])
            dataStr = str(f.readline()[:-1])
            dataPub = date(int(dataStr[6:10]), int(dataStr[3:5]), int(dataStr[0:2]))
            editora = str(f.readline()[:-1])
            resumoPart = str(f.readline())
            resumo = ''
            while resumoPart != '\n' and resumoPart != '':
                resumo += resumoPart
                resumoPart = str(f.readline())

            resumo = resumo[:-1]

            livro = Livro(codigo, titulo, autor, assunto, dataPub, editora, resumo)
            self.adicionaLivro(livro)

    def atualizarCatalago(self, arquivo):
        f = open(arquivo, 'r')
        line = f.readline()

        while line != '':
            # Leitura de dados em caso de inserção ou alteração
            if line == 'i\n' or line == 'a\n':
                codigo = str(f.readline()[:-1])
                titulo = str(f.readline()[:-1])
                autor = str(f.readline()[:-1])
                assunto = str(f.readline()[:-1])
                dataStr = str(f.readline()[:-1])
                dataPub = date(int(dataStr[6:10]), int(dataStr[3:5]), int(dataStr[0:2]))
                editora = str(f.readline()[:-1])
                resumoPart = str(f.readline())
                resumo = ''
                while resumoPart != '\n' and resumoPart != '':
                    resumo += resumoPart
                    resumoPart = str(f.readline())

                resumo = resumo[:-1]

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
                codigo = str(f.readline()[:-1])
                self.removeLivro(codigo)

            line = f.readline()

    def escreverSaida(self, arquivo):
        f = open(arquivo, 'w')
        f.write("Listagem de livros\n")
        for livro in self.__livros:
            f.write('\n')
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')

    def escreverCatalago(self, arquivo):
        f = open(arquivo, 'w')

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

    # Função de Ordenação (Seletion Sort)
    def ordena(self, comparador):
        N = len(self.__livros)
        for i in range(0, N):
            minPos = i
            for j in range(i, N):
                if comparador(self.__livros[j], self.__livros[minPos]) == -1:
                    minPos = j

            # Swap livros
            self.__livros[i], self.__livros[minPos] = self.__livros[minPos], self.__livros[i]
