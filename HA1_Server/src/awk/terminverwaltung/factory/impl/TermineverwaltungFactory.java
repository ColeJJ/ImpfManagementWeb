package awk.terminverwaltung.factory.impl;

import awk.terminverwaltung.factory.ITermineverwaltungFactory;
import awk.terminverwaltung.usecase.IImpfungPflegen;
import awk.terminverwaltung.usecase.ITerminePflegen;
import awk.terminverwaltung.usecase.ITermineSuchen;
import awk.terminverwaltung.usecase.impl.ImpfungPflegen;
import awk.terminverwaltung.usecase.impl.TerminePflegen;
import awk.terminverwaltung.usecase.impl.TermineSuchen;

public class TermineverwaltungFactory implements ITermineverwaltungFactory{

	@Override
	public ITerminePflegen getTerminePflegen() {
		return new TerminePflegen();
	}

	@Override
	public ITermineSuchen getTermineSuchen() {
		return new TermineSuchen();
	}

	@Override
	public IImpfungPflegen getImpfungPflegen() {
		return new ImpfungPflegen();
	}

}
