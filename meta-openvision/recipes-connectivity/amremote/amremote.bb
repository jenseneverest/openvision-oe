SUMMARY = "AML remote setup"
LICENSE = "GPLv2"
SECTION = "base"
PRIORITY = "required"

require conf/license/license-gplv2.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit gitpkgv

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/amremote.git;protocol=git"

S = "${WORKDIR}/git"

do_compile() {
    oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${sysconfdir}/amremote
	install -m 0755 ${S}/remotecfg ${D}${bindir}/
	if [ "${MACHINE}" = "wetekplay2" -o "${MACHINE}" = "wetekhub" ]; then
		install -m 0644 ${S}/wetek_play2.conf ${D}${sysconfdir}/amremote/wetek.conf
	elif [ "${MACHINE}" = "alien5" ]; then
		install -m 0644 ${S}/alien5.conf ${D}${sysconfdir}/amremote/remote.conf
	elif [ "${MACHINE}" = "k1pro" -o "${MACHINE}" = "k2pro" -o "${MACHINE}" = "k2prov2" -o "${MACHINE}" = "k3pro" ]; then
		install -m 0644 ${S}/k1pro.conf ${D}${sysconfdir}/amremote/remote.conf
	elif [ "${MACHINE}" = "k1plus" -o "${MACHINE}" = "k1plusv2" ]; then
		install -m 0644 ${S}/k1plus.conf ${D}${sysconfdir}/amremote/remote.conf
	elif [ "${MACHINE}" = "wetekplay" ]; then
		install -m 0644 ${S}/wetek0.conf ${D}${sysconfdir}/amremote/wetek.conf
	else
		install -m 0644 ${S}/wetek0.conf ${D}${sysconfdir}/amremote/remote.conf
	fi
	install -m 0644 ${S}/*.conf ${D}${sysconfdir}/amremote/
}

FILES_${PN} = "${bindir} ${sysconfdir}"
