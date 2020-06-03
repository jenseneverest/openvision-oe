DESCRIPTION = "Inittab for sysvinit"

require conf/license/openvision-gplv2.inc


SRC_URI = "file://inittab"

S = "${WORKDIR}/sysvinit-${PV}"

INHIBIT_DEFAULT_DEPS = "1"

do_compile() {
	:
}

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/inittab ${D}${sysconfdir}/inittab
}
