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
	install -m 0644 ${S}/wetek.conf ${D}${sysconfdir}/amremote/wetek.conf
    else
    	install -m 0644 ${S}/wetek.conf ${D}${sysconfdir}/amremote/remote.conf
    fi
    install -m 0644 ${S}/a400.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/alien.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/alien2.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/alien5.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/factory_remote.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/gb800ueplus.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/gilx3.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/k1plus.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/k1pro.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/m8s.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/m8splus.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/mb2.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/mx3g.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/mxpro2.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/mxqv20.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/mxqv31.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/octagonsf8.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/qintex.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/rc5.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/remotercmm.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/tx1.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/tx3pro.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/tx5pro.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/vander.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/wechipv5.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/wetek.conf ${D}${sysconfdir}/amremote/wetek0.conf
    install -m 0644 ${S}/wetek1.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/wetek2.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/wetek3.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/wetek_et10000remote.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/wetek_hd2400remote.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/wetek_ipbox9900remote.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/wetek_play2.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/wetek_tmnanoremote.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/x96.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/x98.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${S}/zgemmastar.conf ${D}${sysconfdir}/amremote/
}

FILES_${PN} = "${bindir} ${sysconfdir}"
