function [A,b,n,tempo] = gerador(n,factor);
	tic;
	A = rand(n,n);
	b = rand(n,1);
	for i=1:n
		A(i,i)=factor*sum(A(i,:));
	end
	tempo = toc;
end

