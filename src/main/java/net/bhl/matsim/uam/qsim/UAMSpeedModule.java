package net.bhl.matsim.uam.qsim;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.matsim.core.controler.AbstractModule;
import org.matsim.core.mobsim.qsim.qnetsimengine.linkspeedcalculator.DefaultLinkSpeedCalculator;

import java.util.Map;

/**
 * A MATSim Abstract Module for classes used by UAM simulation regarding link
 * speeds in the simulation.
 *
 * @author balacmi (Milos Balac), RRothfeld (Raoul Rothfeld)
 */
public class UAMSpeedModule extends AbstractModule {

	final private Map<String, Double> mapVehicleVerticalSpeeds;
	final private Map<String, Double> mapVehicleHorizontalSpeeds;
	final private Map<String, Double> mapVehicleDiagonalSpeeds;

	public UAMSpeedModule(Map<String, Double> mapVehicleVerticalSpeeds,
						  Map<String, Double> mapVehicleHorizontalSpeeds, Map<String, Double> mapVehicleDiagonalSpeeds) {
		this.mapVehicleVerticalSpeeds = mapVehicleVerticalSpeeds;
		this.mapVehicleHorizontalSpeeds = mapVehicleHorizontalSpeeds;
		this.mapVehicleDiagonalSpeeds = mapVehicleDiagonalSpeeds;
	}

	@Override
	public void install() {

	}

	@Provides
	@Singleton
	public UAMLinkSpeedCalculator provideUAMLinkSpeedCalculator() {
		DefaultLinkSpeedCalculator delegate = new DefaultLinkSpeedCalculator();
		return new UAMLinkSpeedCalculator(mapVehicleVerticalSpeeds, mapVehicleHorizontalSpeeds, mapVehicleDiagonalSpeeds, delegate);
	}
}
