package test;

import java.util.ArrayList;
import java.util.List;

import entities.Employee;
import manage.dao.EmployeeDAOImpl;
import manage.dao.EventsDaoImpl;

public class testmain {
	public static String jsonemp() {
		 List<Employe> employees = new ArrayList<>();

	        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

	        List<Employee> emlist = employeeDAO.getAllEmployees();
        EventsDaoImpl evdao= new EventsDaoImpl();
	        for (Employee em : emlist) { int i =24-evdao.getAllAbsentsForEmployee(em.getEmployeeID(),"06","2024").size();
	            employees.add(new Employe(""+em.getCode(), "101523065714", ""+i, ""+em.getEsiNumber(), em.getFirstName()+" "+ em.getLastName(),""+ em.getPaymentMode(),""+ em.getPosition(), ""+em.getAccountNumber(),
	                    new String[][]{
	                            {"Base", (em.getBase()*i)+".00"},
	                            {"DA", "550.00"},
	                            {"HRA", "1650.00"},
	                            {"WA", "120.00"},
	                            {"CA", "0.00"},
	                            {"CCA", "0.00"},
	                            {"MA", "3000.00"},
	                            {"Prime de vente", "0.00"},
	                            {"Encaissement de congé", "0.00"},
	                            {"Salaires de vacances", "500.00"},
	                            {"Allocation spéciale", "100.00"},
	                            {"Bonus", "1400.00"},
	                            {"Prime individuelle", "2400.00"}
	                    },
	                    new String[][]{
	                            {"PF", "1800.00"},
	                            {"ESI", "142.00"},
	                            {"TDS", "0.00"},
	                            {"LOP", "0.00"},
	                            {"PT", "0.00"},
	                            {"Déduction spéciale", "500.00"},
	                            {"EWF", "0.00"},
	                            {"CD", "0.00"}
	                    },
	                    "", ""));
	        }

	        // Generate JSON
	        StringBuilder jsonBuilder = new StringBuilder();
	        jsonBuilder.append("var employés = [\n");
	        for (Employe employee : employees) {
	            jsonBuilder.append(employee.toJSON()).append(",\n");
	        }
	        int lastCommaIndex = jsonBuilder.lastIndexOf(",");
	        if (lastCommaIndex != -1) {
	            jsonBuilder.deleteCharAt(lastCommaIndex);
	        }

	        jsonBuilder.append("\n];");

	        // Output JSON
	        return jsonBuilder.toString();
	}
    
	public static String jsonempid(int emp) {
		 List<Employe> employees = new ArrayList<>();

	        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

	        Employee em = employeeDAO.getEmployeeById(emp);
       EventsDaoImpl evdao= new EventsDaoImpl();
	         int i =24-evdao.getAllAbsentsForEmployee(em.getEmployeeID(),"06","2024").size();
	            employees.add(new Employe(""+em.getCode(), "101523065714", ""+i, ""+em.getEsiNumber(), em.getFirstName()+" "+ em.getLastName(),""+ em.getPaymentMode(),""+ em.getPosition(), ""+em.getAccountNumber(),
	                    new String[][]{
	                            {"Base", (em.getBase()*i)+".00"},
	                            {"DA", "550.00"},
	                            {"HRA", "1650.00"},
	                            {"WA", "120.00"},
	                            {"CA", "0.00"},
	                            {"CCA", "0.00"},
	                            {"MA", "3000.00"},
	                            {"Prime de vente", "0.00"},
	                            {"Encaissement de congé", "0.00"},
	                            {"Salaires de vacances", "500.00"},
	                            {"Allocation spéciale", "100.00"},
	                            {"Bonus", "1400.00"},
	                            {"Prime individuelle", "2400.00"}
	                    },
	                    new String[][]{
	                            {"PF", "1800.00"},
	                            {"ESI", "142.00"},
	                            {"TDS", "0.00"},
	                            {"LOP", "0.00"},
	                            {"PT", "0.00"},
	                            {"Déduction spéciale", "500.00"},
	                            {"EWF", "0.00"},
	                            {"CD", "0.00"}
	                    },
	                    "", ""));
	        

	        // Generate JSON
	        StringBuilder jsonBuilder = new StringBuilder();
	        jsonBuilder.append("var employés = [\n");
	        for (Employe employee : employees) {
	            jsonBuilder.append(employee.toJSON()).append(",\n");
	        }
	        int lastCommaIndex = jsonBuilder.lastIndexOf(",");
	        if (lastCommaIndex != -1) {
	            jsonBuilder.deleteCharAt(lastCommaIndex);
	        }

	        jsonBuilder.append("\n];");

	        // Output JSON
	        return jsonBuilder.toString();
	}
  public static void main(String[] args) {
        List<Employe> employees = new ArrayList<>();

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        List<Employee> emlist = employeeDAO.getAllEmployees();

        for (Employee em : emlist) { 
            employees.add(new Employe(""+em.getCode(), "101523065714", "xx", ""+em.getEsiNumber(), em.getFirstName()+" "+ em.getLastName(),""+ em.getPaymentMode(),""+ em.getPosition(), ""+em.getAccountNumber(),
                    new String[][]{
                            {"Base", "16250.00"},
                            {"DA", "550.00"},
                            {"HRA", "1650.00"},
                            {"WA", "120.00"},
                            {"CA", "0.00"},
                            {"CCA", "0.00"},
                            {"MA", "3000.00"},
                            {"Prime de vente", "0.00"},
                            {"Encaissement de congé", "0.00"},
                            {"Salaires de vacances", "500.00"},
                            {"Allocation spéciale", "100.00"},
                            {"Bonus", "1400.00"},
                            {"Prime individuelle", "2400.00"}
                    },
                    new String[][]{
                            {"PF", "1800.00"},
                            {"ESI", "142.00"},
                            {"TDS", "0.00"},
                            {"LOP", "0.00"},
                            {"PT", "0.00"},
                            {"Déduction spéciale", "500.00"},
                            {"EWF", "0.00"},
                            {"CD", "0.00"}
                    },
                    "24528.00", "Vingt-cinq mille cinq cent vingt-huit"));
        }
        

        // Generate JSON
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("var employés = [\n");
        for (Employe employee : employees) {
            jsonBuilder.append(employee.toJSON()).append(",\n");
        }
        int lastCommaIndex = jsonBuilder.lastIndexOf(",");
        if (lastCommaIndex != -1) {
            jsonBuilder.deleteCharAt(lastCommaIndex);
        }

        jsonBuilder.append("\n];");

        // Output JSON
       // System.out.println(jsonBuilder.toString());
        System.out.println(jsonempid(1));
    }
}

class Employe {
    private String codeEmp;
    private String noPf;
    private String nod;
    private String noEsi;
    private String nomEmp;
    private String modeDePaiement;
    private String poste;
    private String noAc;
    private String[][] gains;
    private String[][] deductions;
    private String salaireNet;
    private String enMots;

    public Employe(String codeEmp, String noPf, String nod, String noEsi, String nomEmp, String modeDePaiement, String poste, String noAc, String[][] gains, String[][] deductions, String salaireNet, String enMots) {
        this.codeEmp = codeEmp;
        this.noPf = noPf;
        this.nod = nod;
        this.noEsi = noEsi;
        this.nomEmp = nomEmp;
        this.modeDePaiement = modeDePaiement;
        this.poste = poste;
        this.noAc = noAc;
        this.gains = gains;
        this.deductions = deductions;
        this.salaireNet = salaireNet;
        this.enMots = enMots;
    }

    public String toJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");
        jsonBuilder.append("\"codeEmp\": \"").append(codeEmp).append("\",\n");
        jsonBuilder.append("\"noPf\": \"").append(noPf).append("\",\n");
        jsonBuilder.append("\"nod\": \"").append(nod).append("\",\n");
        jsonBuilder.append("\"noEsi\": \"").append(noEsi).append("\",\n");
        jsonBuilder.append("\"nomEmp\": \"").append(nomEmp).append("\",\n");
        jsonBuilder.append("\"modeDePaiement\": \"").append(modeDePaiement).append("\",\n");
        jsonBuilder.append("\"poste\": \"").append(poste).append("\",\n");
        jsonBuilder.append("\"noAc\": \"").append(noAc).append("\",\n");

        jsonBuilder.append("\"gains\": [\n");
        for (String[] gain : gains) {
            jsonBuilder.append("[\"").append(gain[0]).append("\", \"").append(gain[1]).append("\"],\n");
        }
        jsonBuilder.deleteCharAt(jsonBuilder.lastIndexOf(","));
        jsonBuilder.append("],\n");

        jsonBuilder.append("\"déductions\": [\n");
        for (String[] deduction : deductions) {
            jsonBuilder.append("[\"").append(deduction[0]).append("\", \"").append(deduction[1]).append("\"],\n");
        }
        jsonBuilder.deleteCharAt(jsonBuilder.lastIndexOf(","));
        jsonBuilder.append("],\n");

        jsonBuilder.append("\"salaireNet\": \"").append(salaireNet).append("\",\n");
        jsonBuilder.append("\"enMots\": \"").append(enMots).append("\"\n");
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}
