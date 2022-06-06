package control;

import java.io.IOException;



import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.DuplicataDao;
import entity.Duplicata;




/**
 * Servlet implementation class ControleDuplicata
 */
@WebServlet({"/ControleDuplicata","/cadastrar.html","/consultarPorCedente.html","/consultarPorData.html","/consultarTodas.html", "/excluir.html"})
public class ControleDuplicata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleDuplicata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		execute(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		execute(request,response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String url= request.getServletPath();
			if(url.equalsIgnoreCase("/cadastrar.html")) {
				cadastrar(request,response);
			}else if(url.equalsIgnoreCase("/consultarTodas.html")) {
				consultar(request,response);
			}else if(url.equalsIgnoreCase("/consultarPorData.html")) {
				consultarPorData(request,response);
			}
			else if(url.equalsIgnoreCase("/consultarPorCedente.html")) {
				consultarPorCedente(request,response);
			}else if(url.equalsIgnoreCase("/excluir.html")) {
				excluir(request,response);
			}
		else if(url.equalsIgnoreCase("/consultarValorPagarPorData.html")) {
			excluir(request,response);
		}
			else {
				
		
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		finally{
		// TODO Auto-generated method stub
		
	}
		}


	private void consultarPorCedente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String cedente=request.getParameter("cedente");
			request.setAttribute("cedente",cedente);
			DuplicataDao DD=new DuplicataDao();
			List<Duplicata> lista=DD.consultarPorCedente(cedente);
			if(lista.size()==0) {
				request.setAttribute("msg","<div='alert alert-sucess'>"+"Nenhuma duplicata encontrada!</div>");

			}//atribui a lista na lista que estará em buscar.jsp
			request.setAttribute("lista", lista);

			//chamar funcionariodao
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","<div='alert alert-sucess'>"+"Erro na busca!</div>");
		}finally{
			request.getRequestDispatcher("consultarPorCedente.jsp").forward(request, response);
		}

	}

	private void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String cedente= request.getParameter("cedente");
		String dataVencimento= request.getParameter("dataVencimento");
		String valor= request.getParameter("valor");
		String banco= request.getParameter("banco");
		String notaFiscal= request.getParameter("notaFiscal");
		String pago= request.getParameter("pago");
		Duplicata d= new Duplicata();
		d.setCedente(cedente);
		d.setDataVencimento(dataVencimento);
		d.setValor(valor);
		d.setBanco(banco);
		d.setNotaFiscal(notaFiscal);
		d.setPago(pago);
	
	
		//imprimir dados na tela
		out.print("<b> Dados Enviados ao Servidor</b>");
		out.print(" ");
		out.print("\n<b> Cedente</b>"+cedente);
		out.print(" ");
		out.print("\n<b> Data de Vencimento</b>"+dataVencimento);
		out.print(" ");
		out.print("\n<b> Valor</b>"+valor);
		out.print(" ");
		out.print("\n<b> Banco</b>"+banco);
		out.print(" ");
		out.print("\n<b> Nota Fiscal</b>"+notaFiscal);
		out.print(" ");
		out.print("\n<b> Pago</b>"+pago);
	}

			
		

	private void consultarPorData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String dataVencimento=request.getParameter("dataVencimento");
			request.setAttribute("dataVencimento",dataVencimento);
			DuplicataDao DD=new DuplicataDao();
			List<Duplicata> lista=DD.consultarPorData(dataVencimento);
			if(lista.size()==0) {
				request.setAttribute("msg","<div='alert alert-sucess'>"+"Nenhum boleto encontrado!</div>");

			}//atribui a lista na lista que estará em buscar.jsp
			request.setAttribute("lista", lista);

			//chamar funcionariodao
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","<div='alert alert-sucess'>"+"Erro na busca!</div>");
		}finally{
			request.getRequestDispatcher("consultarPorData.jsp").forward(request, response);
		}

	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar os dados da tela
		try {
		String cedente= request.getParameter("cedente");
		String dataVencimento= request.getParameter("dataVencimento");
		String valor= request.getParameter("valor");
		String banco= request.getParameter("banco");
		String notaFiscal= request.getParameter("notaFiscal");
		String pago= request.getParameter("pago");
		
		Duplicata duplicata =new Duplicata();
		duplicata.setCedente(cedente);
		duplicata.setDataVencimento(dataVencimento);
		duplicata.setValor(valor);
		duplicata.setBanco(banco);
		duplicata.setNotaFiscal(notaFiscal);
		duplicata.setPago(pago);


		new DuplicataDao().gravar(duplicata);
		request.setAttribute("msg","<div='alert alert-sucess'>"+"Boleto Cadastrado com sucesso</div>");
				
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","<div='alert alert-sucess'>"+"Não Cadastrado</div>");
		}finally {
			request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
		}
			
		}
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer id=  Integer.parseInt(request.getParameter("id"));
			
			DuplicataDao dd= new DuplicataDao();
			if(dd.excluir(id)) {
				request.setAttribute("msg","<div='alert alert-sucess'>"+"Cedente Excluido com sucesso!</div>");

			}
	
		} catch (Exception e) {
			request.setAttribute("msg","<div='alert alert-sucess'>"+"Cedente não excluido!</div>");
		}finally {
			request.getRequestDispatcher("consultarPorCedente.jsp").forward(request, response);
		}
	}


	}
	







