function [x,iter,erro,tempo] = sor(A,b,n,tol,kmax,w)
	tic;
	x = zeros(n,1);
	x_o = zeros(n,1);
	for i=1:n
		r = 1/A(i,i);
		for j=1:n
			if i~=j
				A(i,j)=r*A(i,j);
			end
		end
		b(i) = r*b(i);
		x_o(i) = b(i);
		x(i) = x_o(i);
	end	

	iter = 0;
	erro = tol + 1;	
	while (erro > tol && iter < kmax)
		iter = iter + 1;
		for i=1:n
			Soma = 0;
			for j=1:n
				if i~=j 
					Soma = Soma + A(i,j)*x(j);
				end	
			end
			x_o(i) = x(i);
			x(i) = b(i) - Soma;
			
		end
		for i=1:n
			x(i) = w*x(i) + (1-w)*x_o(i);
		end
		Norma1 = 0;
		Norma2 = 0;
		for i=1:n
			if abs(x(i)-x_o(i))>Norma1
				Norma1 = abs(x(i)-x_o(i));
			end
			if abs(x(i))>Norma2
				Norma2 = abs(x(i));
			end
			
		end
		erro = Norma1/Norma2;
	end
	tempo=toc;
end