module ar.sizpope {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;
  requires org.slf4j;

  opens ar.sizpope.controller to javafx.fxml;
  exports ar.sizpope;
}

