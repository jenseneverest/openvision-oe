# Open version should replace old Vision version of the same plugin. This
# include file arranges that the Open version is newer, and that the
# old Vision plugin is removed on install.

OLDPKG = "${@d.getVar('PN', True).replace('-extensions-','-vision-')}"
RREPLACES_${PN} = "${OLDPKG}"
RCONFLICTS_${PN} = "${OLDPKG}"

inherit gitpkgv

PV = "2.0+git${SRCPV}"
PKGV = "2.0+git${GITPKGV}"
