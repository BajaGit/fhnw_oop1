package baja.oop1.lesson2;

public class GI {
	/**
	 * This method computes the yearly membership fees for the German GI.
	 * 
	 * @param salaryPerYear
	 *            The year's salary of the member.
	 * @param partnerMembership
	 *            Indicates, whether the affiliate of this member is already a
	 *            regular member.
	 * @param memberOfAssociatedOrganization
	 *            Indicates, wehther the member is already a member of an
	 *            associated organization.
	 * @param retired
	 *            Indicates, whether the member is already retired.
	 * @return the yearly membership fees this member has to pay.
	 */
	public static double membershipFee(double salaryPerYear,
			boolean partnerMembership, boolean memberOfAssociatedOrganization,
			boolean retired) {
		
		if ( partnerMembership){
			return 15;
		}
		if ( salaryPerYear <= 13000){
			return 16;
		}
		if (memberOfAssociatedOrganization && retired){
			return 17.5;
		}
		if ( retired){
			return 43;
		}
		if ( memberOfAssociatedOrganization){
			return 50;
		}
		return 86.0;
	}
}
