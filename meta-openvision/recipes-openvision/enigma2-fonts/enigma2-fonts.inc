SUMMARY = "Enigma2 font ${FONTNAME}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/enigma2-fonts.git;protocol=git"

S = "${WORKDIR}/git/${FONTNAME}"

do_install() {
    install -d ${D}${datadir}/fonts
    cp -r  --preserve=mode,links ${S}/*.ttf ${D}${datadir}/fonts
}

do_package_qa[noexec] = "1"

FILES_${PN} = "${datadir}/fonts"
