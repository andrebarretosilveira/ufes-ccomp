function [x,tempo] = elim_gauss(A,b,n)
	tic;
	for k=1:n-1
		for i=k+1:n
			m = -A(i,k)/A(k,k);
			for j=k:n
				A(i,j) = A(i,j) + m*A(k,j);
			end
			b(i) = b(i) + m*b(k);
		end
	end
	x = zeros(n,1);
	x(n) = b(n)/A(n,n);
	for i=n-1:-1:1
		soma = 0;
		for j=i+1:n
			soma = soma + A(i,j)*x(j);
		end
		x(i) = (b(i)-soma)/A(i,i);
	end
	tempo = toc;
end



