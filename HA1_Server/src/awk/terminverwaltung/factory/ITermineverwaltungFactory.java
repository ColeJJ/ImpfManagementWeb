package awk.terminverwaltung.factory;

import awk.terminverwaltung.usecase.IImpfungPflegen;
import awk.terminverwaltung.usecase.ITerminePflegen;
import awk.terminverwaltung.usecase.ITermineSuchen;

public interface ITermineverwaltungFactory {

	ITerminePflegen getTerminePflegen();
	ITermineSuchen getTermineSuchen();
	IImpfungPflegen getImpfungPflegen();
}
