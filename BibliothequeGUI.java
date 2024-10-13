import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Livre {
    public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	private String titre;
    private String theme;
    private String ISBN;
    private int exemplairesDisponibles;

    public void setExemplairesDisponibles(int exemplairesDisponibles) {
		this.exemplairesDisponibles = exemplairesDisponibles;
	}

	public Livre(String titre, String theme, String ISBN, int exemplairesDisponibles) {
        this.titre = titre;
        this.theme = theme;
        this.ISBN = ISBN;
        this.exemplairesDisponibles = exemplairesDisponibles;
    }

    public String getTitre() {
        return titre;
    }

    public String getTheme() {
        return theme;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getExemplairesDisponibles() {
        return exemplairesDisponibles;
    }

    public void decrementExemplairesDisponibles() {
        exemplairesDisponibles--;
    }
    
    public int dec(int exemplaire) {
        return exemplaire--;
    }


    public void incrementExemplairesDisponibles() {
        exemplairesDisponibles++;
    }

    @Override
    public String toString() {
        return titre + " son thème est  " + theme + " (ISBN : " + ISBN + ") - Exemplaires disponibles : " + exemplairesDisponibles;
    }

	
}

 class Enseignant {
    public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	private String nom;
    private String prenom;
    private String identifiant;
    private String telephone;
    private String grade;

    public Enseignant(String nom, String prenom, String identifiant, String telephone, String grade) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.telephone = telephone;
        this.grade = grade;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Prénom: " + prenom + ", Identifiant: " + identifiant + ", Téléphone: " + telephone + ", Grade: " + grade;
    }
}


class Etudiant {
    public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	private String matricule;
    private String nom;
    private String prenom;
    private String specialite;
    private String telephone;

    public Etudiant(String matricule, String nom, String prenom, String specialite, String telephone) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.telephone = telephone;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return "Matricule: " + matricule + ", Nom: " + nom + ", Prénom: " + prenom + ", Spécialité: " + specialite + ", Téléphone: " + telephone;
    }
}




class Emprunt {
    private Livre livre;
    private Etudiant etudiant;
    private Enseignant enseignant;
    private boolean estEtudiant;
    private Date dateEmprunt;

    public Emprunt(Livre livre, Etudiant etudiant) {
        this.livre = livre;
        this.etudiant = etudiant;
        this.estEtudiant = true;
        this.dateEmprunt = new Date(); // Date d'emprunt initialisée à la date actuelle
    }

    public Emprunt(Livre livre, Enseignant enseignant) {
        this.livre = livre;
        this.enseignant = enseignant;
        this.estEtudiant = false;
        this.dateEmprunt = new Date(); // Date d'emprunt initialisée à la date actuelle
    }
    
    public boolean estEtudiant() {
        return estEtudiant;
    }
    
    public Enseignant getEnseignant() {
        return enseignant;
    }

    public Livre getLivre() {
        return livre;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }
}




public class BibliothequeGUI extends JFrame {
    
    private static BibliothequeGUI instance;
    public static boolean convertirStringEnInt(String chaine) {
        try {
            // Tentative de conversion de la chaîne en entier
            Integer.parseInt(chaine);
            // Si la conversion réussit, retourner true
            return true;
        } catch (NumberFormatException e) {
            // Si une exception NumberFormatException est levée, cela signifie que la conversion a échoué
            // Retourner false dans ce cas
            return false;
        }}
    public BibliothequeGUI() {
        // Création de la fenêtre de login
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 150);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new BorderLayout());
        loginFrame.setLocationRelativeTo(null);
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); // Pour remplir la grille
        loginPanel.add(loginButton);

        loginFrame.add(loginPanel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                // Si la validation réussit, vous pouvez ouvrir la fenêtre principale BibliothequeGUI
                if (username.equals("admin") && password.equals("admin")) { 
                    loginFrame.dispose(); // Ferme la fenêtre de connexion
                    initBibliotheque(); // Initialise la fenêtre principale
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Nom d'utilisateur ou mot de passe incorrect.", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginFrame.setVisible(true); // Affiche la fenêtre de connexion
    }

    // Initialise la fenêtre principale de la bibliothèque
    private void initBibliotheque() {
      
        setTitle("Gestion de Bibliothèque");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 110, 20)); // Ajout d'espacement horizontal et vertical
        JButton operationLivresButton = new JButton("Espace de livre");
        JButton operationEtudiantsButton = new JButton("Espace de l'étudiant");
        JButton operationEnseignantsButton = new JButton("Espace Enseignant");
        JButton suiviLivresButton = new JButton("Suivi des Livres");
        Dimension buttonSize = new Dimension(200, 40); // Largeur: 200, Hauteur: 50
        operationLivresButton.setPreferredSize(buttonSize);
        operationEtudiantsButton.setPreferredSize(buttonSize);
        operationEnseignantsButton.setPreferredSize(buttonSize);
        suiviLivresButton.setPreferredSize(buttonSize);
        buttonPanel.add(operationLivresButton);
        buttonPanel.add(operationEtudiantsButton);
        buttonPanel.add(operationEnseignantsButton);
        buttonPanel.add(suiviLivresButton);
       
        add(buttonPanel, BorderLayout.NORTH);

        // Chargement de l'image
        ImageIcon imageIcon = new ImageIcon("D:\\home page.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        add(imageLabel, BorderLayout.CENTER);

        operationEnseignantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FenetreEnseignants fenetreEnseignants = new FenetreEnseignants();
                fenetreEnseignants.setVisible(true);
            }
        });

        operationLivresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FenetreLivres fenetreLivres = new FenetreLivres();
                fenetreLivres.setVisible(true);
            }
        });

        operationEtudiantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FenetreEtudiants fenetreEtudiants = new FenetreEtudiants();
                fenetreEtudiants.setVisible(true);
            }
        });

        suiviLivresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuiviLivres suiviLivres = new SuiviLivres();
                suiviLivres.setVisible(true);
            }
        });
        
        setVisible(true); // Affiche la fenêtre principale de la bibliothèque
    }
    public static synchronized BibliothequeGUI getInstance() {
        if (instance == null) {
            instance = new BibliothequeGUI();
        }
        return instance;
    }

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BibliothequeGUI.getInstance();
            }
        });
    }
}

class SuiviLivres extends JFrame {
	
    
    static List<Emprunt> listeEmprunts = new ArrayList<Emprunt>();;
    
   


    public SuiviLivres() {
    	 //FenetreLivres.livresParISBN;
    	// FenetreEtudiants.listeEtudiants;
    	
        setTitle("Suivi des Livres");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton ajouterEmpruntButton = new JButton("Ajouter un Emprunt");
        JButton voirLivresEmpruntesButton = new JButton("Voir les Livres Empruntés");
        JButton envoyerMessagesButton = new JButton("Anuller Empruntation");
        JButton rechercheEmpruntButton = new JButton("Rechercher Emprunt");
        JButton voirRetardatairesButton = new JButton("Voir les Retardataires");


        panel.add(ajouterEmpruntButton);
        panel.add(voirLivresEmpruntesButton);
        panel.add(envoyerMessagesButton);
        panel.add(rechercheEmpruntButton);
        panel.add(voirRetardatairesButton);

        add(panel);
        ajouterEmpruntButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Étudiant", "Enseignant"};
                int choice = JOptionPane.showOptionDialog(null, "Choisissez le type d'emprunteur :", "Type d'emprunteur", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (choice == 0) { // Si l'utilisateur choisit "Étudiant"
                    String isbn = JOptionPane.showInputDialog(null, "Entrez l'ISBN du livre :", "Ajouter un Emprunt", JOptionPane.QUESTION_MESSAGE);
                    String matricule = JOptionPane.showInputDialog(null, "Entrez le matricule de l'étudiant :", "Ajouter un Emprunt", JOptionPane.QUESTION_MESSAGE);

                    if (isbn != null && matricule != null) {
                        // Vérifier si l'étudiant existe dans la liste
                        Etudiant etudiant = null;
                        for (Etudiant e1 : FenetreEtudiants.listeEtudiants) {
                            if (e1.getMatricule().equals(matricule)) {
                                etudiant = e1;
                                break;
                            }
                        }
                        if (etudiant != null) {
                            // Vérifier si l'étudiant a déjà emprunté un livre
                            for (Emprunt emprunt : listeEmprunts) {
                                if (emprunt.getEtudiant() != null && emprunt.getEtudiant().equals(etudiant)) {
                                    JOptionPane.showMessageDialog(null, "L'étudiant a déjà emprunté un livre. L'emprunt actuel est annulé.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                            }
                            // Continuer avec le processus d'emprunt si l'étudiant n'a pas déjà emprunté un livre
                            List<Livre> livres = FenetreLivres.livresParISBN.get(isbn);
                            if (livres != null) {
                                for (Livre livre : livres) {
                                    if (livre.getExemplairesDisponibles() > 1) {
                                        // Livre disponible, on peut l'emprunter
                                        Emprunt emprunt = new Emprunt(livre, etudiant);
                                        listeEmprunts.add(emprunt);
                                        livre.decrementExemplairesDisponibles();
                                        
                                        // Afficher toutes les informations du livre et de l'étudiant
                                        String message = "Livre emprunté avec succès!\n\n" +
                                                         "Informations sur le livre :\n" +
                                                         livre.toString() + "\n\n" +
                                                         "Informations sur l'étudiant :\n" +
                                                         etudiant.toString();
                                        JOptionPane.showMessageDialog(null, message, "Emprunt", JOptionPane.INFORMATION_MESSAGE);
                                        return;
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "Aucun exemplaire disponible pour ce livre.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Aucun livre trouvé avec l'ISBN spécifié.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Aucun étudiant trouvé avec le matricule spécifié.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (choice == 1) { // Si l'utilisateur choisit "Enseignant"
                    String isbn = JOptionPane.showInputDialog(null, "Entrez l'ISBN du livre :", "Ajouter un Emprunt", JOptionPane.QUESTION_MESSAGE);
                    String identifiant = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'enseignant :", "Ajouter un Emprunt", JOptionPane.QUESTION_MESSAGE);

                    if (isbn != null && identifiant != null) {
                        // Vérifier si l'enseignant existe dans la liste
                        Enseignant enseignant = null;
                        for (Enseignant e1 : FenetreEnseignants.listeEnseignants) {
                            if (e1.getIdentifiant().equals(identifiant)) {
                                enseignant = e1;
                                break;
                            }
                        }
                        if (enseignant != null) {
                            // Vérifier si l'enseignant a déjà emprunté un livre
                            for (Emprunt emprunt : listeEmprunts) {
                                if (emprunt.getEnseignant() != null && emprunt.getEnseignant().equals(enseignant)) {
                                    JOptionPane.showMessageDialog(null, "L'enseignant a déjà emprunté un livre. L'emprunt actuel est annulé.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                            }
                            // Continuer avec le processus d'emprunt si l'enseignant n'a pas déjà emprunté un livre
                            List<Livre> livres = FenetreLivres.livresParISBN.get(isbn);
                            if (livres != null) {
                                for (Livre livre : livres) {
                                    if (livre.getExemplairesDisponibles() > 0) {
                                        // Livre disponible, on peut l'emprunter
                                        Emprunt emprunt = new Emprunt(livre, enseignant);
                                        listeEmprunts.add(emprunt);
                                        livre.decrementExemplairesDisponibles();
                                        
                                        // Afficher toutes les informations du livre et de l'enseignant
                                        String message = "Livre emprunté avec succès!\n\n" +
                                                         "Informations sur le livre :\n" +
                                                         livre.toString() + "\n\n" +
                                                         "Informations sur l'enseignant :\n" +
                                                         enseignant.toString();
                                        JOptionPane.showMessageDialog(null, message, "Emprunt",JOptionPane.INFORMATION_MESSAGE);
                                        return;
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "Aucun exemplaire disponible pour ce livre.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Aucun livre trouvé avec l'ISBN spécifié.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Aucun enseignant trouvé avec l'identifiant spécifié.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });



        voirLivresEmpruntesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder empruntsDetails = new StringBuilder();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                for (Emprunt emprunt : listeEmprunts) {
                    Livre livre = emprunt.getLivre();
                    Date dateEmprunt = emprunt.getDateEmprunt();
                    
                    String emprunteurType;
                    String emprunteurNom;
                    
                    if (emprunt.getEtudiant() != null) {
                        emprunteurType = "Étudiant";
                        emprunteurNom = emprunt.getEtudiant().getNom() + " (Matricule: " + emprunt.getEtudiant().getMatricule() + ")";
                    } else if (emprunt.getEnseignant() != null) {
                        emprunteurType = "Enseignant";
                        emprunteurNom = emprunt.getEnseignant().getNom() + " (Identifiant: " + emprunt.getEnseignant().getIdentifiant() + ")";
                    } else {
                        emprunteurType = "Inconnu";
                        emprunteurNom = "Inconnu";
                    }

                    empruntsDetails.append("Livre: ").append(livre.getTitre()).append(" son thème est :  ").append(livre.getTheme())
                                    .append(" (ISBN: ").append(livre.getISBN()).append(")")
                                    .append(" - Emprunté par: ").append(emprunteurNom).append(" (").append(emprunteurType).append(")")
                                    .append(" - Date d'emprunt: ").append(dateFormat.format(dateEmprunt)).append("\n");
                }
                if (empruntsDetails.length() > 0) {
                    JOptionPane.showMessageDialog(null, empruntsDetails.toString(), "Livres Empruntés", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Aucun livre n'a été emprunté.", "Livres Empruntés", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        envoyerMessagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = JOptionPane.showInputDialog(null, "Entrez l'ISBN du livre :", "Annuler Emprunt", JOptionPane.QUESTION_MESSAGE);
                String identifiant = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'enseignant ou le matricule de l'étudiant :", "Annuler Emprunt", JOptionPane.QUESTION_MESSAGE);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                if (isbn != null && identifiant != null) {
                    // Recherche de l'emprunt correspondant à la combinaison ISBN et identifiant
                    Emprunt empruntToRemove = null;
                    for (Emprunt emprunt : listeEmprunts) {
                        if (emprunt.getLivre().getISBN().equals(isbn)) {
                            if ((emprunt.getEtudiant() != null && emprunt.getEtudiant().getMatricule().equals(identifiant)) ||
                                (emprunt.getEnseignant() != null && emprunt.getEnseignant().getIdentifiant().equals(identifiant))) {
                                empruntToRemove = emprunt;
                                break;
                            }
                        }
                    }

                    // Si l'emprunt correspondant est trouvé, afficher un message de confirmation
                    if (empruntToRemove != null) {
                        // Calculer la date de retour prévue en ajoutant 15 jours à la date d'emprunt
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(empruntToRemove.getDateEmprunt());
                        calendar.add(Calendar.DAY_OF_MONTH, 15);
                        Date dateRetourPrevue = calendar.getTime();

                        // Construire le message de confirmation
                        StringBuilder messageConfirmation = new StringBuilder();
                        messageConfirmation.append("Confirmation de l'annulation de l'emprunt :\n\n");
                        messageConfirmation.append("Livre :\n").append(empruntToRemove.getLivre().toString()).append("\n\n");
                        if (empruntToRemove.getEtudiant() != null) {
                            messageConfirmation.append("Emprunté par l'étudiant :\n").append(empruntToRemove.getEtudiant().toString()).append("\n");
                        } else if (empruntToRemove.getEnseignant() != null) {
                            messageConfirmation.append("Emprunté par l'enseignant :\n").append(empruntToRemove.getEnseignant().toString()).append("\n");
                        }
                        messageConfirmation.append("Date de retour prévue : ").append(dateFormat.format(dateRetourPrevue)).append("\n\n");
                        messageConfirmation.append("Voulez-vous vraiment annuler cet emprunt ?");

                        // Afficher le message de confirmation
                        int option = JOptionPane.showConfirmDialog(null, messageConfirmation.toString(), "Confirmation Annulation Emprunt", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            // Annuler l'emprunt
                            listeEmprunts.remove(empruntToRemove);
                            empruntToRemove.getLivre().incrementExemplairesDisponibles(); // Rétablir l'exemplaire disponible
                            JOptionPane.showMessageDialog(null, "L'emprunt a été annulé avec succès.", "Annuler Emprunt", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Aucun emprunt trouvé avec la combinaison spécifiée.", "Annuler Emprunt", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        voirRetardatairesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fonction pour afficher les retardataires
                Map<String, Date> retardataires = new HashMap<>();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, -15); // Retourner 15 jours en arrière pour vérifier les retards
                
                for (Emprunt emprunt : listeEmprunts) {
                    Date dateEmprunt = emprunt.getDateEmprunt();
                    Date dateRetourPrevue = (Date) dateEmprunt.clone(); // Cloner la date d'emprunt
                    calendar.setTime(dateRetourPrevue);
                    calendar.add(Calendar.DAY_OF_MONTH, 15); // Ajouter 15 jours à la date d'emprunt
                    dateRetourPrevue = calendar.getTime(); // Date de retour prévue
                    
                    if (dateRetourPrevue.compareTo(new Date()) < 0) {
                        // L'emprunt est en retard
                        String retardataireNom;
                        if (emprunt.estEtudiant()) {
                            retardataireNom = emprunt.getEtudiant().getNom() + " (Matricule: " + emprunt.getEtudiant().getMatricule() + ")";
                        } else {
                            retardataireNom = emprunt.getEnseignant().getNom() + " (Identifiant: " + emprunt.getEnseignant().getIdentifiant() + ")";
                        }
                        retardataires.put(retardataireNom, dateRetourPrevue);
                    }
                }
                
                // Afficher les retardataires
                if (!retardataires.isEmpty()) {
                    StringBuilder retardatairesDetails = new StringBuilder();
                    for (Map.Entry<String, Date> entry : retardataires.entrySet()) {
                        retardatairesDetails.append("Nom: ").append(entry.getKey()).append(" - Date de retour prévue: ").append(dateFormat.format(entry.getValue())).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, retardatairesDetails.toString(), "Retardataires", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Aucun retardataire trouvé.", "Retardataires", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        
        rechercheEmpruntButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = JOptionPane.showInputDialog(null, "Entrez l'ISBN du livre :", "Rechercher Emprunt", JOptionPane.QUESTION_MESSAGE);
                String identifiant = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'enseignant ou le matricule de l'étudiant :", "Rechercher Emprunt", JOptionPane.QUESTION_MESSAGE);

                if (isbn != null && identifiant != null) {
                    
                    Emprunt empruntTrouve = null;
                    for (Emprunt emprunt : listeEmprunts) {
                        if (emprunt.getLivre().getISBN().equals(isbn)) {
                            if ((emprunt.getEtudiant() != null && emprunt.getEtudiant().getMatricule().equals(identifiant)) ||
                                (emprunt.getEnseignant() != null && emprunt.getEnseignant().getIdentifiant().equals(identifiant))) {
                                empruntTrouve = emprunt;
                                break;
                            }
                        }
                    }

                   
                    if (empruntTrouve != null) {
                        StringBuilder message = new StringBuilder();
                        message.append("Informations sur l'emprunt :\n\n");
                        message.append("Livre :\n").append(empruntTrouve.getLivre().toString()).append("\n\n");
                        if (empruntTrouve.estEtudiant()) {
                            message.append("Emprunté par l'étudiant :\n").append(empruntTrouve.getEtudiant().toString()).append("\n");
                        } else {
                            message.append("Emprunté par l'enseignant :\n").append(empruntTrouve.getEnseignant().toString()).append("\n");
                        }
                        
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(empruntTrouve.getDateEmprunt());
                        calendar.add(Calendar.DAY_OF_MONTH, 15);
                        Date dateRetourPrevue = calendar.getTime();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        message.append("Date de retour prévue : ").append(dateFormat.format(dateRetourPrevue)).append("\n\n");

                        JOptionPane.showMessageDialog(null, message.toString(), "Résultat de la Recherche", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Aucun emprunt trouvé avec la combinaison spécifiée.", "Résultat de la Recherche", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        
       
    }
}

class FenetreLivres extends JFrame {
	static Map<String, List<Livre>> livresParISBN = Collections.synchronizedMap(new HashMap<String, List<Livre>>());

    
    public FenetreLivres() {
    	   

        setTitle("Opérations sur les Livres");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton ajouterButton = new JButton("Ajouter Livre");
        JButton voirTousButton = new JButton("Voir Tous les Livres");
        JButton voirExemplairesButton = new JButton("Voir Exemplaires");
        JButton voirDemandesButton = new JButton("Voir Demandes");
        JButton supprimerButton = new JButton("Supprimer Livre");
        JButton modifierButton = new JButton("Modifier Livre");

        panel.add(ajouterButton);
        panel.add(voirTousButton);
        panel.add(voirExemplairesButton);
        panel.add(modifierButton);
        panel.add(supprimerButton);
        panel.add(voirDemandesButton);

        add(panel);

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ajouterLivreFrame = new JFrame("Ajouter un Livre");
                ajouterLivreFrame.setSize(300, 200);
                ajouterLivreFrame.setLayout(new GridLayout(5, 2));
                ajouterLivreFrame.setSize(500, 300); 
                ajouterLivreFrame.setLocationRelativeTo(null); 


                JTextField titreField = new JTextField();
                JTextField auteurField = new JTextField();
                JTextField isbnField = new JTextField();
                JTextField exemplairesField = new JTextField();

                ajouterLivreFrame.add(new JLabel("Titre:"));
                ajouterLivreFrame.add(titreField);
                ajouterLivreFrame.add(new JLabel("Thème:"));
                ajouterLivreFrame.add(auteurField);
                ajouterLivreFrame.add(new JLabel("ISBN:"));
                ajouterLivreFrame.add(isbnField);
                ajouterLivreFrame.add(new JLabel("Exemplaires disponibles:"));
                ajouterLivreFrame.add(exemplairesField);

                JButton validerButton = new JButton("Valider");
                validerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String titre = titreField.getText();
                        String auteur = auteurField.getText();
                        String isbn = isbnField.getText();
                        
                        int exemplaires;
                        try {
                            exemplaires = Integer.parseInt(exemplairesField.getText());
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide pour le nombre d'exemplaires.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        if (exemplaires <= 0) {
                            JOptionPane.showMessageDialog(null, "Nombre d'exemplaire non valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Vérifier si l'ISBN est déjà présent dans la liste des livres
                        if (livresParISBN.containsKey(isbn)) {
                            JOptionPane.showMessageDialog(null, "ISBN déjà existant dans la liste des livres.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Vérifier si tous les champs sont remplis
                        if (isbn.isEmpty() || !BibliothequeGUI.convertirStringEnInt(isbn)) {
                            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs. et entrer un isbn de valeur numerique strictement positive", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        Livre livre = new Livre(titre, auteur, isbn, exemplaires);
                        List<Livre> livres = livresParISBN.getOrDefault(isbn, new ArrayList<>());
                        livres.add(livre);
                        livresParISBN.put(isbn, livres);
                        
                        ajouterLivreFrame.dispose();
                    }
                });
                ajouterLivreFrame.add(validerButton);

                ajouterLivreFrame.setVisible(true);
            }
        });



        voirTousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder livresDetails = new StringBuilder();
                for (List<Livre> livres : livresParISBN.values()) {
                    for (Livre livre : livres) {
                        livresDetails.append(livre.toString()).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, livresDetails.toString(), "Tous les livres", JOptionPane.PLAIN_MESSAGE);
            }
        });

        voirExemplairesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = JOptionPane.showInputDialog(null, "Entrez l'ISBN du livre:", "Voir Exemplaires", JOptionPane.QUESTION_MESSAGE);
                if (isbn != null && !isbn.isEmpty()) { 
                    List<Livre> livres = livresParISBN.get(isbn);
                    if (livres != null) {
                        StringBuilder message = new StringBuilder();
                        message.append("Informations sur le(s) livre(s) avec ISBN ").append(isbn).append(":\n");
                        for (Livre livre : livres) {
                            message.append("Titre: ").append(livre.getTitre()).append("\n");
                            message.append("Thème: ").append(livre.getTheme()).append("\n");
                            message.append("Nombre d'exemplaires disponibles: ").append(livre.getExemplairesDisponibles()).append("\n");
                            message.append("\n");
                        }
                        JOptionPane.showMessageDialog(null, message.toString(), "Informations sur le livre", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Aucun livre trouvé pour ISBN " + isbn, "Exemplaires disponibles", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer un ISBN valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        voirDemandesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "Aucune demande!!", "la liste des demandes", JOptionPane.PLAIN_MESSAGE);
            }
        });

        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = JOptionPane.showInputDialog(null, "Entrez l'ISBN du livre à supprimer:", "Supprimer Livre", JOptionPane.QUESTION_MESSAGE);
                if (isbn != null) {
                    // Vérifier si le livre est emprunté
                    boolean isBookBorrowed = false;
                    for (Emprunt emprunt : SuiviLivres.listeEmprunts) {
                        if (emprunt.getLivre() != null && emprunt.getLivre().getISBN().equals(isbn)) {
                            isBookBorrowed = true;
                            break;
                        }
                    }
                    if (isBookBorrowed) {
                        JOptionPane.showMessageDialog(null, "Le livre avec ISBN " + isbn + " est emprunté, la suppression est impossible.", "Supprimer Livre", JOptionPane.WARNING_MESSAGE);
                    } else {
                        // Si le livre n'est pas emprunté, procéder à la suppression
                        List<Livre> livres = livresParISBN.get(isbn);
                        if (livres != null) {
                            // Afficher les informations du livre
                            StringBuilder livreInfo = new StringBuilder();
                            for (Livre livre : livres) {
                                livreInfo.append("Titre: ").append(livre.getTitre()).append("\n");
                                livreInfo.append("Thème: ").append(livre.getTheme()).append("\n");
                                livreInfo.append("Nombre d'exemplaires disponibles: ").append(livre.getExemplairesDisponibles()).append("\n");
                            }
                            livreInfo.append("\nCombien d'exemplaires voulez-vous supprimer ?");
                            String input = JOptionPane.showInputDialog(null, livreInfo.toString(), "Supprimer Livre", JOptionPane.QUESTION_MESSAGE);
                            if (input != null) {
                                try {
                                    int numExemplairesASupprimer = Integer.parseInt(input);
                                    if (numExemplairesASupprimer > 0) {
                                        // Vérifier si le nombre d'exemplaires à supprimer est valide
                                        if (numExemplairesASupprimer <= livres.get(0).getExemplairesDisponibles()) {
                                            // Vérifier si le nombre d'exemplaires restants est au moins deux
                                            if (livres.get(0).getExemplairesDisponibles() - numExemplairesASupprimer >= 2) {
                                                livres.get(0).setExemplairesDisponibles(livres.get(0).getExemplairesDisponibles() - numExemplairesASupprimer);
                                                JOptionPane.showMessageDialog(null, numExemplairesASupprimer + " exemplaire(s) du livre avec ISBN " + isbn + " supprimé(s) avec succès.", "Supprimer Livre", JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Il doit rester au moins deux exemplaires du livre après la suppression.", "Supprimer Livre", JOptionPane.WARNING_MESSAGE);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Nombre d'exemplaires à supprimer supérieur au nombre d'exemplaires disponibles.", "Supprimer Livre", JOptionPane.WARNING_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide d'exemplaires à supprimer.", "Supprimer Livre", JOptionPane.WARNING_MESSAGE);
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide d'exemplaires à supprimer.", "Supprimer Livre", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Aucun livre trouvé pour ISBN " + isbn, "Supprimer Livre", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        });
        
        modifierButton.addActionListener(new ActionListener() {
            Livre livre = null;
            public void actionPerformed(ActionEvent e) {
                String isbn = JOptionPane.showInputDialog(null, "Entrez l'ISBN du livre à modifier:", "Modifier Livre", JOptionPane.QUESTION_MESSAGE);
                if (isbn != null) {
                    // Recherche du livre dans la liste
                    for (Map.Entry<String, List<Livre>> entry : livresParISBN.entrySet()) {
                        for (Livre liv : entry.getValue()) {
                            if (liv.getISBN().equals(isbn)) {
                                livre = liv;
                                break;
                            }
                        }
                        if (livre != null) {
                            break;
                        }
                    }
                    if (livre != null) {
                        // Vérifier si le livre est emprunté
                        boolean isBookBorrowed = false;
                        for (Emprunt emprunt : SuiviLivres.listeEmprunts) {
                            if (emprunt.getLivre().getISBN().equals(isbn)) {
                                isBookBorrowed = true;
                                break;
                            }
                        }
                        if (isBookBorrowed) {
                            JOptionPane.showMessageDialog(null, "Le livre avec ISBN " + isbn + " est emprunté, la modification est impossible.", "Modifier Livre", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        // Créer une nouvelle fenêtre pour modifier les informations du livre
                        JFrame modifierLivreFrame = new JFrame("Modifier un Livre");
                        modifierLivreFrame.setSize(300, 200);
                        modifierLivreFrame.setLayout(new GridLayout(5, 2));
                        modifierLivreFrame.setSize(500, 300); 
                        modifierLivreFrame.setLocationRelativeTo(null);

                        JTextField titreField = new JTextField(livre.getTitre());
                        JTextField auteurField = new JTextField(livre.getTheme());
                        JTextField exemplairesField = new JTextField(String.valueOf(livre.getExemplairesDisponibles()));
                       
                        modifierLivreFrame.add(new JLabel("Titre:"));
                        modifierLivreFrame.add(titreField);
                       
                        
                        modifierLivreFrame.add(new JLabel("Thème:"));
                        modifierLivreFrame.add(auteurField);
                        modifierLivreFrame.add(new JLabel("Exemplaires disponibles:"));
                        modifierLivreFrame.add(exemplairesField);

                        JButton validerButton = new JButton("Valider");
                        validerButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Vérifier si tous les champs sont remplis et si l'ISBN et le nombre d'exemplaires sont des entiers positifs
                                if (  titreField.getText().isEmpty() || auteurField.getText().isEmpty() || exemplairesField.getText().isEmpty()  || !BibliothequeGUI.convertirStringEnInt(exemplairesField.getText())) {
                                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs. L'ISBN et le nombre d'exemplaires doivent être des nombres entiers positifs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }

                                // Vérifier si le nombre d'exemplaires est un entier positif
                                int exemplaires;
                                try {
                                    exemplaires = Integer.parseInt(exemplairesField.getText());
                                    if (exemplaires < 1) {
                                        throw new NumberFormatException();
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Le nombre d'exemplaires doit être un entier positif.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }

                               
                                livre.setTitre(titreField.getText());
                                livre.setTheme(auteurField.getText());
                                livre.setExemplairesDisponibles(exemplaires);
                                JOptionPane.showMessageDialog(null, "Les informations du livre ont été modifiées avec succès.", "Modifier Livre", JOptionPane.INFORMATION_MESSAGE);
                                modifierLivreFrame.dispose();
                            }
                        });
                        modifierLivreFrame.add(validerButton);

                        modifierLivreFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Aucun livre trouvé avec l'ISBN " + isbn, "Modifier Livre", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });





    }
}

class FenetreEnseignants extends JFrame {
    static List<Enseignant> listeEnseignants = new ArrayList<Enseignant>();

    public FenetreEnseignants() {
        setTitle("Opérations sur les Enseignants");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton ajouterEnseignantButton = new JButton("Ajouter Enseignant");
        JButton voirTousEnseignantsButton = new JButton("Voir Tous les Enseignants");
        JButton supprimerEnseignantButton = new JButton("Supprimer Enseignant");
        JButton rechercherEnseignantButton = new JButton("Rechercher Enseignant");
        JButton modifierEnseignantButton = new JButton("Modifier Enseignant");
        
        panel.add(ajouterEnseignantButton);
        panel.add(voirTousEnseignantsButton);
        panel.add(rechercherEnseignantButton);
        panel.add(modifierEnseignantButton);
        panel.add(supprimerEnseignantButton);

        add(panel);

        ajouterEnseignantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ajouterEnseignantFrame = new JFrame("Ajouter un Enseignant");
                ajouterEnseignantFrame.setSize(500, 300); 
                ajouterEnseignantFrame.setLocationRelativeTo(null); 

                // Utiliser un JPanel pour organiser les composants
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(6, 1));

                JTextField nomField = new JTextField();
                JTextField prenomField = new JTextField();
                JTextField identifiantField = new JTextField();
                JTextField telephoneField = new JTextField();
                JTextField gradeField = new JTextField();

                panel.add(new JLabel("Nom:"));
                panel.add(nomField);
                panel.add(new JLabel("Prénom:"));
                panel.add(prenomField);
                panel.add(new JLabel("Identifiant:"));
                panel.add(identifiantField);
                panel.add(new JLabel("Téléphone:"));
                panel.add(telephoneField);
                panel.add(new JLabel("Grade:"));
                panel.add(gradeField);

                JButton validerButton = new JButton("Valider");
                validerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nom = nomField.getText();
                        String prenom = prenomField.getText();
                        String identifiant = identifiantField.getText();
                        String telephone = telephoneField.getText();
                        String grade = gradeField.getText();

                        // Vérifier si l'identifiant est vide
                        if (identifiant.isEmpty() || prenom.isEmpty() || nom.isEmpty() || !BibliothequeGUI.convertirStringEnInt(identifiant) || !BibliothequeGUI.convertirStringEnInt(telephone)) {
                            JOptionPane.showMessageDialog(null, "Veuillez remplire le nom prénom et l'identifant. et assurer que l'identifant et le théléphone soit de nombre entier postive", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return; // Arrêter le traitement si l'identifiant est vide
                        }

                        // Vérifier si l'identifiant existe déjà
                        boolean identifiantExisteEnseignant = false;
                        for (Enseignant enseignant : listeEnseignants) {
                            if (enseignant.getIdentifiant().equals(identifiant)) {
                                identifiantExisteEnseignant = true;
                                break;
                            }
                        }

                        if (identifiantExisteEnseignant) {
                            JOptionPane.showMessageDialog(null, "L'identifiant existe déjà. Veuillez entrer un identifiant différent.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        } else {
                            Enseignant enseignant = new Enseignant(nom, prenom, identifiant, telephone, grade);
                            listeEnseignants.add(enseignant);
                            ajouterEnseignantFrame.dispose();
                        }
                    }
                });
                panel.add(validerButton);

                ajouterEnseignantFrame.add(panel);
                ajouterEnseignantFrame.setVisible(true);
            }
        });




        voirTousEnseignantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder enseignantsDetails = new StringBuilder();
                for (Enseignant enseignant : listeEnseignants) {
                    enseignantsDetails.append(enseignant.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, enseignantsDetails.toString(), "Tous les enseignants", JOptionPane.PLAIN_MESSAGE);
            }
        });

        supprimerEnseignantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String identifiant = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'enseignant à supprimer:", "Supprimer Enseignant", JOptionPane.QUESTION_MESSAGE);
                if (identifiant != null) {
                    // Recherche de l'enseignant dans la liste
                    Enseignant enseignantToDelete = null;
                    for (Enseignant enseignant : FenetreEnseignants.listeEnseignants) {
                        if (enseignant.getIdentifiant().equals(identifiant)) {
                            enseignantToDelete = enseignant;
                            break;
                        }
                    }

                    // Vérification si l'enseignant existe
                    if (enseignantToDelete != null) {
                        // Vérification des emprunts de l'enseignant
                        boolean hasBorrowedBooks = false;
                        for (Emprunt emprunt : SuiviLivres.listeEmprunts) {
                            if (emprunt.getEnseignant() != null && emprunt.getEnseignant().getIdentifiant().equals(identifiant)) {
                                hasBorrowedBooks = true;
                                break;
                            }
                        }
                        
                        // Si l'enseignant a des emprunts en cours, afficher un message d'erreur
                        if (hasBorrowedBooks) {
                            JOptionPane.showMessageDialog(null, "Impossible de supprimer l'enseignant car il a des emprunts en cours.", "Supprimer Enseignant", JOptionPane.WARNING_MESSAGE);
                        } else {
                            // Affichage des informations de l'enseignant
                            String enseignantInfo = "Nom: " + enseignantToDelete.getNom() + "\n" +
                                                    "Prénom: " + enseignantToDelete.getPrenom() + "\n" +
                                                    "Identifiant: " + enseignantToDelete.getIdentifiant() + "\n" +
                                                    "Téléphone: " + enseignantToDelete.getTelephone() + "\n" +
                                                    "Grade: " + enseignantToDelete.getGrade();
                            int option = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cet enseignant ?\n\n" + enseignantInfo, "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.YES_OPTION) {
                                // Supprimer l'enseignant de la liste
                                FenetreEnseignants.listeEnseignants.remove(enseignantToDelete);
                                JOptionPane.showMessageDialog(null, "Enseignant avec identifiant " + identifiant + " supprimé avec succès.", "Supprimer Enseignant", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Aucun enseignant trouvé avec identifiant " + identifiant, "Supprimer Enseignant", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });


        rechercherEnseignantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String identifiant = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'enseignant à rechercher:", "Rechercher Enseignant", JOptionPane.QUESTION_MESSAGE);
                if (identifiant != null) {
                    boolean enseignantTrouve = false;
                    for (Enseignant enseignant : listeEnseignants) {
                        if (enseignant.getIdentifiant().equals(identifiant)) {
                            StringBuilder message = new StringBuilder();
                            message.append("Informations de l'enseignant trouvé : \n");
                            message.append("Nom : ").append(enseignant.getNom()).append("\n");
                            message.append("Prénom : ").append(enseignant.getPrenom()).append("\n");
                            message.append("Identifiant : ").append(enseignant.getIdentifiant()).append("\n");
                            message.append("Téléphone : ").append(enseignant.getTelephone()).append("\n");
                            message.append("Grade : ").append(enseignant.getGrade()).append("\n");
                            JOptionPane.showMessageDialog(null, message.toString(), "Enseignant trouvé", JOptionPane.INFORMATION_MESSAGE);
                            enseignantTrouve = true;
                            break;
                        }
                    }
                    if (!enseignantTrouve) {
                        JOptionPane.showMessageDialog(null, "Aucun enseignant trouvé avec l'identifiant " + identifiant, "Rechercher Enseignant", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        
        modifierEnseignantButton.addActionListener(new ActionListener() {
            Enseignant enseignant = null;
            public void actionPerformed(ActionEvent e) {
                String identifiant = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'enseignant à modifier:", "Modifier Enseignant", JOptionPane.QUESTION_MESSAGE);
                if (identifiant != null && !identifiant.isEmpty()) {
                    // Recherche de l'enseignant dans la liste
                    for (Enseignant ens : listeEnseignants) {
                        if (ens.getIdentifiant().equals(identifiant)) {
                            enseignant = ens;
                            break;
                        }
                    }
                    if (enseignant != null) {
                        // Créer une nouvelle fenêtre pour modifier les informations de l'enseignant
                        JFrame modifierEnseignantFrame = new JFrame("Modifier un Enseignant");
                        modifierEnseignantFrame.setSize(300, 200);
                        modifierEnseignantFrame.setLayout(new GridLayout(6, 2));
                        modifierEnseignantFrame.setSize(500, 300); 
                        modifierEnseignantFrame.setLocationRelativeTo(null); 

                        JTextField nomField = new JTextField(enseignant.getNom());
                        JTextField prenomField = new JTextField(enseignant.getPrenom());
                        JTextField identifiantField = new JTextField(enseignant.getIdentifiant());
                        JTextField telephoneField = new JTextField(enseignant.getTelephone());
                        JTextField gradeField = new JTextField(enseignant.getGrade());
                        modifierEnseignantFrame.add(new JLabel("Nom:"));
                        modifierEnseignantFrame.add(nomField);
                        modifierEnseignantFrame.add(new JLabel("Prénom:"));
                        modifierEnseignantFrame.add(prenomField);
                        modifierEnseignantFrame.add(new JLabel("Identifiant:"));
                        modifierEnseignantFrame.add(identifiantField);
                        modifierEnseignantFrame.add(new JLabel("Téléphone:"));
                        modifierEnseignantFrame.add(telephoneField);
                        modifierEnseignantFrame.add(new JLabel("Grade:"));
                        modifierEnseignantFrame.add(gradeField);

                        JButton validerButton = new JButton("Valider");
                        validerButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Récupérer les valeurs des champs au moment du clic sur le bouton "Valider"
                                String identifiantValue = identifiantField.getText();
                                String telephoneValue = telephoneField.getText();
                                // Vérifier si tous les champs sont remplis
                                if (nomField.getText().isEmpty() || prenomField.getText().isEmpty() || identifiantValue.isEmpty() || telephoneValue.isEmpty() || gradeField.getText().isEmpty() || !BibliothequeGUI.convertirStringEnInt(identifiantValue) || !BibliothequeGUI.convertirStringEnInt(telephoneValue)) {
                                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs et assurez-vous que l'identifiant soit un entier strictement positif.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                                // Mettre à jour les informations de l'enseignant
                                String newIdentifiant = identifiantValue;
                                // Vérifier si le nouvel identifiant est différent de l'identifiant initial
                                if (!newIdentifiant.equals(identifiant)) {
                                    // Vérifier si le nouvel identifiant existe déjà
                                    for (Enseignant ens : listeEnseignants) {
                                        if (ens.getIdentifiant().equals(newIdentifiant)) {
                                            JOptionPane.showMessageDialog(null, "L'identifiant existe déjà. Veuillez entrer un identifiant différent.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                    }
                                }
                                enseignant.setNom(nomField.getText());
                                enseignant.setPrenom(prenomField.getText());
                                enseignant.setIdentifiant(newIdentifiant);
                                enseignant.setTelephone(telephoneValue);
                                enseignant.setGrade(gradeField.getText());
                                JOptionPane.showMessageDialog(null, "Les informations de l'enseignant ont été modifiées avec succès.", "Modifier Enseignant", JOptionPane.INFORMATION_MESSAGE);
                                modifierEnseignantFrame.dispose();
                            }
                        });
                        modifierEnseignantFrame.add(validerButton);

                        modifierEnseignantFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Aucun enseignant trouvé avec identifiant " + identifiant, "Modifier Enseignant", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer un identifiant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });




    }
}

class FenetreEtudiants extends JFrame {
    static List<Etudiant> listeEtudiants  = new ArrayList<Etudiant>();

    public FenetreEtudiants( ) {
       

        setTitle("Opérations sur les Étudiants");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton ajouterButton = new JButton("Ajouter Étudiant");
        JButton voirTousButton = new JButton("Voir Tous les Étudiants");
        JButton supprimerButton = new JButton("Supprimer Étudiant");
        JButton rechercherButton = new JButton("Rechercher Étudiant");
        JButton modifierButton = new JButton("Modifier Étudiant");
        

        panel.add(ajouterButton);
        panel.add(voirTousButton);
        panel.add(rechercherButton);
        panel.add(modifierButton);
        
        panel.add(supprimerButton);
        
        add(panel);

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ajouterEtudiantFrame = new JFrame("Ajouter un Étudiant");
                ajouterEtudiantFrame.setSize(300, 250);
                ajouterEtudiantFrame.setSize(500, 300); 
                ajouterEtudiantFrame.setLocationRelativeTo(null); 


                // Utiliser un JPanel pour organiser les composants
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(6, 2));

                JTextField matriculeField = new JTextField();
                JTextField nomField = new JTextField();
                JTextField prenomField = new JTextField();
                JTextField specialiteField = new JTextField();
                JTextField telephoneField = new JTextField();

                panel.add(new JLabel("Matricule:"));
                panel.add(matriculeField);
                panel.add(new JLabel("Nom:"));
                panel.add(nomField);
                panel.add(new JLabel("Prénom:"));
                panel.add(prenomField);
                panel.add(new JLabel("Spécialité:"));
                panel.add(specialiteField);
                panel.add(new JLabel("Téléphone:"));
                panel.add(telephoneField);

                JButton validerButton = new JButton("Valider");
                validerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String matricule = matriculeField.getText();
                        String nom = nomField.getText();
                        String prenom = prenomField.getText();
                        String specialite = specialiteField.getText();
                        String telephone = telephoneField.getText();

                        // Vérifier si le matricule est vide
                        if (matricule.isEmpty() || nom.isEmpty()  || prenom.isEmpty() || !BibliothequeGUI.convertirStringEnInt(matricule) || !BibliothequeGUI.convertirStringEnInt(telephone)) {
                            JOptionPane.showMessageDialog(null, "Veuillez entrer le matricule ,nom et le prénom de l'étudiant.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return; // Arrêter le traitement si le matricule est vide
                        }

                        // Vérifier si le matricule existe déjà
                        boolean matriculeExisteEtudiant = false;
                        for (Etudiant etudiant : listeEtudiants) {
                            if (etudiant.getMatricule().equals(matricule)) {
                                matriculeExisteEtudiant = true;
                                break;
                            }
                        }

                        if (matriculeExisteEtudiant) {
                            JOptionPane.showMessageDialog(null, "Le matricule existe déjà. Veuillez entrer un matricule différent.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        } else {
                            Etudiant etudiant = new Etudiant(matricule, nom, prenom, specialite, telephone);
                            listeEtudiants.add(etudiant);
                         
                            ajouterEtudiantFrame.dispose();
                        }
                    }
                });
                panel.add(validerButton);

                ajouterEtudiantFrame.add(panel);
                ajouterEtudiantFrame.setVisible(true);
            }
        });




        voirTousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder etudiantsDetails = new StringBuilder();
                for (Etudiant etudiant : listeEtudiants) {
                    etudiantsDetails.append(etudiant.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, etudiantsDetails.toString(), "Tous les étudiants", JOptionPane.PLAIN_MESSAGE);
            }
        });

        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricule = JOptionPane.showInputDialog(null, "Entrez le matricule de l'étudiant à supprimer:", "Supprimer Étudiant", JOptionPane.QUESTION_MESSAGE);
                if (matricule != null) {
                    boolean found = false;
                    Etudiant etudiantToRemove = null;
                    // Vérifier si l'étudiant a des emprunts en cours
                    for (Emprunt emprunt : SuiviLivres.listeEmprunts) {
                        if (emprunt.getEtudiant() != null && emprunt.getEtudiant().getMatricule().equals(matricule)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        JOptionPane.showMessageDialog(null, "Cet étudiant a une emprunt en cours. Vous ne pouvez pas le supprimer.", "Supprimer Étudiant", JOptionPane.WARNING_MESSAGE);
                    } else {
                        // Rechercher l'étudiant dans la liste
                        for (Etudiant etudiant : listeEtudiants) {
                            if (etudiant.getMatricule().equals(matricule)) {
                                etudiantToRemove = etudiant;
                                break;
                            }
                        }
                        if (etudiantToRemove != null) {
                            // Afficher les informations de l'étudiant
                            StringBuilder message = new StringBuilder();
                            message.append("Informations de l'étudiant à supprimer : \n");
                            message.append("Matricule : ").append(etudiantToRemove.getMatricule()).append("\n");
                            message.append("Nom : ").append(etudiantToRemove.getNom()).append("\n");
                            message.append("Prénom : ").append(etudiantToRemove.getPrenom()).append("\n");
                            message.append("Spécialité : ").append(etudiantToRemove.getSpecialite()).append("\n");
                            
                            // Demander une confirmation de suppression
                            int option = JOptionPane.showConfirmDialog(null, message.toString(), "Confirmation de Suppression", JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.YES_OPTION) {
                                // Supprimer l'étudiant
                                listeEtudiants.remove(etudiantToRemove);
                                JOptionPane.showMessageDialog(null, "Étudiant avec matricule " + matricule + " supprimé avec succès.", "Supprimer Étudiant", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Aucun étudiant trouvé avec matricule " + matricule, "Supprimer Étudiant", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        });

        
        rechercherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricule = JOptionPane.showInputDialog(null, "Entrez le matricule de l'étudiant à rechercher:", "Rechercher Étudiant", JOptionPane.QUESTION_MESSAGE);
                if (matricule != null) {
                    Etudiant etudiant = null;
                    for (Etudiant et : listeEtudiants) {
                        if (et.getMatricule().equals(matricule)) {
                            etudiant = et;
                            break;
                        }
                    }
                    if (etudiant != null) {
                        // Afficher les informations de l'étudiant trouvé
                        StringBuilder message = new StringBuilder();
                        message.append("Informations de l'étudiant trouvé : \n");
                        message.append("Matricule : ").append(etudiant.getMatricule()).append("\n");
                        message.append("Nom : ").append(etudiant.getNom()).append("\n");
                        message.append("Prénom : ").append(etudiant.getPrenom()).append("\n");
                        message.append("Spécialité : ").append(etudiant.getSpecialite()).append("\n");
                        JOptionPane.showMessageDialog(null, message.toString(), "Étudiant trouvé", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Aucun étudiant trouvé avec matricule " + matricule, "Rechercher Étudiant", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        
        modifierButton.addActionListener(new ActionListener() {
            Etudiant etudiant = null;
            public void actionPerformed(ActionEvent e) {
                String matricule = JOptionPane.showInputDialog(null, "Entrez le matricule de l'étudiant à modifier:", "Modifier Étudiant", JOptionPane.QUESTION_MESSAGE);
                if (matricule != null && !matricule.isEmpty()) {
                    // Rechercher l'étudiant dans la liste
                    for (Etudiant et : listeEtudiants) {
                        if (et.getMatricule().equals(matricule)) {
                            etudiant = et;
                            break;
                        }
                    }
                    if (etudiant != null) {
                        // Créer une nouvelle fenêtre pour modifier les informations de l'étudiant
                        JFrame modifierEtudiantFrame = new JFrame("Modifier un Étudiant");
                        modifierEtudiantFrame.setSize(300, 200);
                        modifierEtudiantFrame.setLayout(new GridLayout(6, 1));
                        modifierEtudiantFrame.setSize(500, 300); 
                        modifierEtudiantFrame.setLocationRelativeTo(null); 


                        JTextField nomField = new JTextField(etudiant.getNom());
                        JTextField prenomField = new JTextField(etudiant.getPrenom());
                        JTextField specialiteField = new JTextField(etudiant.getSpecialite());
                        JTextField telephoneField = new JTextField(etudiant.getTelephone());
                        modifierEtudiantFrame.add(new JLabel("Nom:"));
                        modifierEtudiantFrame.add(nomField);
                        modifierEtudiantFrame.add(new JLabel("Prénom:"));
                        modifierEtudiantFrame.add(prenomField);
                        modifierEtudiantFrame.add(new JLabel("Spécialité:"));
                        modifierEtudiantFrame.add(specialiteField);
                        modifierEtudiantFrame.add(new JLabel("Téléphone:"));
                        modifierEtudiantFrame.add(telephoneField);

                        JButton validerButton = new JButton("Valider");
                        validerButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Récupérer la valeur du champ de téléphone au moment où le bouton "Valider" est cliqué
                                String tele_ver = telephoneField.getText();
                                // Vérifier si tous les champs sont remplis
                                if (nomField.getText().isEmpty() || prenomField.getText().isEmpty() || specialiteField.getText().isEmpty() || tele_ver.isEmpty() || !BibliothequeGUI.convertirStringEnInt(tele_ver)) {
                                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs avec des valeurs valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                                // Mettre à jour les informations de l'étudiant
                                etudiant.setNom(nomField.getText());
                                etudiant.setPrenom(prenomField.getText());
                                etudiant.setSpecialite(specialiteField.getText());
                                etudiant.setTelephone(tele_ver);
                                JOptionPane.showMessageDialog(null, "Les informations de l'étudiant ont été modifiées avec succès.", "Modifier Étudiant", JOptionPane.INFORMATION_MESSAGE);
                                modifierEtudiantFrame.dispose();
                            }
                        });
                        modifierEtudiantFrame.add(validerButton);

                        modifierEtudiantFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Aucun étudiant trouvé avec matricule " + matricule, "Modifier Étudiant", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer un matricule valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        
    }
}
