PV = "20110114"
DESCRIPTION = "Tune kernel parameters in ${sysconfdir}/sysconf"

require conf/license/openvision-gplv2.inc

PACKAGES = "${PN}"

SRC_URI = "file://sysctl.conf"

# Users may chose to edit or create their own
CONFFILES_${PN} = "${sysconfdir}/sysctl.conf"

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0640 ${WORKDIR}/sysctl.conf ${D}${sysconfdir}/sysctl.conf
}
