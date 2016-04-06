#!/usr/bin/env python
# -*- coding: utf-8 -*-

from data import *

class Livro:
    def __init__(self, codigo, titulo, autor, assunto, dataPub, editora, resumo):
        self.__codigo = codigo
        self.__titulo = titulo
        self.__autor = autor
        self.__assunto = assunto
        self.__dataPub = dataPub
        self.__editora = editora
        self.__resumo = resumo

    def getDados(self):
        dados = [str(self.__codigo)] + [self.__titulo] + [self.__autor] + [self.__assunto] + [self.__dataPub.toString()] + [self.__editora] + [self.__resumo]
        return dados

    def imprime(self):
        print "Código : " + str(self.__codigo)
        print "Livro  : " + str(self.__titulo)
        print "Autor  : " + str(self.__autor)
        print "assunto: " + str(self.__assunto)
        print "dataPub: " + self.__dataPub.toString()
        print "Editora: " + str(self.__editora)
        print "Resumo : " + str(self.__resumo)
        print ""

#    def fazAniversario(self, dataHoje):
#        return self.dataNasc == dataHoje
#
#    def temCRBom(self):
#        return self.cr > 8.5
#
#    def estaEmJubilamento(self, dataHoje):
#        return self.dataMat.dif(dataHoje) > 7
