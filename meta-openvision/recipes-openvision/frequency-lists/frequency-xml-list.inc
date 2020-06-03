SUMMARY = "${FREQUENCY_LIST} for enigma2"
MAINTAINER = "OE-A"

require conf/license/openvision-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/oe-alliance/oe-alliance-tuxbox-common.git;protocol=git"

FILES_${PN} = "/"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/etc/tuxbox/
    install -d ${D}/usr/share/tuxbox

    ln -sf /usr/share ${D}/share

    for i in ${FREQUENCY_LIST}; do
        install -m 0644 ${S}/src/$i ${D}/etc/tuxbox/$i
        ln -sf /etc/tuxbox/$i ${D}/etc/;
        ln -sf /etc/tuxbox/$i ${D}/usr/share/;
        ln -sf /etc/tuxbox/$i ${D}/usr/share/tuxbox/;
    done;
}
